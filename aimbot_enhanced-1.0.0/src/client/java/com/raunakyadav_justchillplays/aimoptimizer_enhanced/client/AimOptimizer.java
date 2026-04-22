package com.raunakyadav_justchillplays.aimoptimizer_enhanced.client;

import com.raunakyadav_justchillplays.aimoptimizer_enhanced.ModState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AimOptimizer {
    private static final double RANGE = 10.0;
    private static final double FOV = 45.0;

    public static void tick(MinecraftClient client) {
        if (!ModState.isEnabled() || client.player == null || client.world == null) {
            return;
        }

        Entity target = findTarget(client);
        if (target != null) {
            lockToTarget(client, target);
        }
    }

    private static Entity findTarget(MinecraftClient client) {
        PlayerEntity player = client.player;
        Vec3d eyePos = player.getEyePos();
        Vec3d lookVec = player.getRotationVec(1.0F);

        List<LivingEntity> targets = client.world.getEntitiesByClass(LivingEntity.class, 
            player.getBoundingBox().expand(RANGE), 
            entity -> entity != player && entity.isAlive());

        return targets.stream()
            .filter(entity -> {
                Vec3d targetPos = entity.getEyePos();
                Vec3d toTarget = targetPos.subtract(eyePos).normalize();
                double dot = lookVec.dotProduct(toTarget);
                double angle = Math.acos(dot) * (180 / Math.PI);
                return angle < FOV;
            })
            .min(Comparator.comparingDouble(entity -> entity.distanceTo(player)))
            .orElse(null);
    }

    private static void lockToTarget(MinecraftClient client, Entity target) {
        PlayerEntity player = client.player;
        Vec3d eyePos = player.getEyePos();
        Vec3d targetPos = target.getBoundingBox().getCenter(); // Aim at center

        double dx = targetPos.x - eyePos.x;
        double dy = targetPos.y - eyePos.y;
        double dz = targetPos.z - eyePos.z;
        double dist = Math.sqrt(dx * dx + dz * dz);

        float targetYaw = (float) (MathHelper.atan2(dz, dx) * (180 / Math.PI)) - 90.0F;
        float targetPitch = (float) (-(MathHelper.atan2(dy, dist) * (180 / Math.PI)));

        float strength = ModState.getMode() == ModState.AimMode.ENHANCED ? 0.3F : 0.15F;

        player.setYaw(lerpAngle(player.getYaw(), targetYaw, strength));
        player.setPitch(lerpAngle(player.getPitch(), targetPitch, strength));
    }

    private static float lerpAngle(float start, float end, float pct) {
        float diff = MathHelper.wrapDegrees(end - start);
        return start + diff * pct;
    }
}
