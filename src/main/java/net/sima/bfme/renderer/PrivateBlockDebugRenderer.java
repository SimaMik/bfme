package net.sima.bfme.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.block.entity.PrivateBlockEntity;
import org.joml.Matrix4f;
@EventBusSubscriber(modid = BFME.MOD_ID, value = Dist.CLIENT)
public class PrivateBlockDebugRenderer {
    private static final Minecraft MC = Minecraft.getInstance();
    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;

        PoseStack poseStack = event.getPoseStack();
        Camera camera = event.getCamera();
        // Границы блока рендерятся на этапе AFTER_TRANSLUCENT_BLOCKS, но только если F3 включен
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            renderBlockBounds(
                    poseStack,
                    mc.renderBuffers().bufferSource(),
                    camera.getPosition().x,
                    camera.getPosition().y,
                    camera.getPosition().z
            );
        }
        // Границы привата рендерятся на этапе AFTER_SOLID_BLOCKS
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) {
            renderPrivateBounds(
                    poseStack,
                    mc.renderBuffers().bufferSource(),
                    camera.getPosition().x,
                    camera.getPosition().y,
                    camera.getPosition().z
            );
        }


    }


    public static void renderPrivateBounds(PoseStack poseStack, MultiBufferSource bufferSource, double camX, double camY, double camZ) {
        if (!MC.getDebugOverlay().showDebugScreen()) {
            return; // Выходим, если дебаг-режим отключён
        }
        if (MC.level == null || MC.player == null) return;

        ClientChunkCache chunkCache = MC.level.getChunkSource();
        int viewRadius = MC.options.renderDistance().get();
        BlockPos playerPos = MC.player.blockPosition();

        for (int x = -viewRadius; x <= viewRadius; x++) {
            for (int z = -viewRadius; z <= viewRadius; z++) {
                LevelChunk chunk = chunkCache.getChunk(x + MC.player.chunkPosition().x, z + MC.player.chunkPosition().z, ChunkStatus.FULL, false);
                if (chunk != null) {
                    for (BlockEntity blockEntity : chunk.getBlockEntities().values()) {
                        if (blockEntity instanceof PrivateBlockEntity privateBlock) {
                            BlockPos pos = privateBlock.getBlockPos();
                            if (pos.distSqr(playerPos) > viewRadius * viewRadius * 16 * 16) continue;
                            renderPrivateBlockArea(poseStack, bufferSource, privateBlock, camX, camY, camZ);
                        }
                    }
                }
            }
        }
    }
    public static void renderBlockBounds(PoseStack poseStack, MultiBufferSource bufferSource, double camX, double camY, double camZ) {
        if (!MC.getDebugOverlay().showDebugScreen()) {
            return; // Выходим, если дебаг-режим отключён
        }

        if (MC.level == null || MC.player == null) return;

        ClientChunkCache chunkCache = MC.level.getChunkSource();
        int viewRadius = MC.options.renderDistance().get(); // Радиус видимости в чанках

        for (int x = -viewRadius; x <= viewRadius; x++) {
            for (int z = -viewRadius; z <= viewRadius; z++) {
                LevelChunk chunk = chunkCache.getChunk(x + MC.player.chunkPosition().x, z + MC.player.chunkPosition().z, ChunkStatus.FULL, false);
                if (chunk != null) {
                    for (BlockEntity blockEntity : chunk.getBlockEntities().values()) {
                        if (blockEntity instanceof PrivateBlockEntity privateBlock) {
                            BlockPos pos = privateBlock.getBlockPos();

                            // Рендерим только границы блока
                            poseStack.pushPose();

                            // Смещаем относительно камеры
                            poseStack.translate(pos.getX() - camX, pos.getY() - camY, pos.getZ() - camZ);

                            // Рендерим границы блока
                            VertexConsumer blockBuilder = bufferSource.getBuffer(RenderType.lines());
                            renderBoundingBox(blockBuilder, poseStack.last().pose(), 0, 0, 0, 1, 1, 1, 0.0f, 1.0f, 0.0f, 1.0f); // Зеленый цвет

                            poseStack.popPose();
                        }
                    }
                }
            }
        }
    }


    private static void renderPrivateBlockArea(PoseStack poseStack, MultiBufferSource bufferSource, PrivateBlockEntity privateBlock, double camX, double camY, double camZ) {
        BlockPos pos = privateBlock.getBlockPos();

        // Получаем размеры границ привата
        int[] coordinates = privateBlock.getCoordinates();
        int xPos = coordinates[0];
        int xNeg = coordinates[1];
        int yPos = coordinates[2];
        int yNeg = coordinates[3];
        int zPos = coordinates[4];
        int zNeg = coordinates[5];

        // Координаты границ привата (чёткие линии вдоль блоков)
        double xMin = pos.getX() - xNeg;
        double xMax = pos.getX() + xPos + 1;
        double yMin = pos.getY() - yNeg;
        double yMax = pos.getY() + yPos + 1;
        double zMin = pos.getZ() - zNeg;
        double zMax = pos.getZ() + zPos + 1;

        // Сдвиг рендера с учётом камеры
        poseStack.pushPose();
        poseStack.translate(xMin - camX, yMin - camY, zMin - camZ);

        // Рендерим границы привата
        VertexConsumer builder = bufferSource.getBuffer(RenderType.lines());
        Matrix4f matrix = poseStack.last().pose();

        renderBoundingBox(builder, matrix, 0, 0, 0, xMax - xMin, yMax - yMin, zMax - zMin, 1.0f, 0.0f, 0.0f, 1.0f); // Красный цвет для границ привата

        poseStack.popPose();

    }
    private static void renderBoundingBox(VertexConsumer builder, Matrix4f matrix, double x, double y, double z, double width, double height, double depth, float r, float g, float b, float alpha) {
        // Нижняя часть
        renderLine(builder, matrix, x, y, z, x + width, y, z, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y, z, x + width, y, z + depth, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y, z + depth, x, y, z + depth, r, g, b, alpha);
        renderLine(builder, matrix, x, y, z + depth, x, y, z, r, g, b, alpha);

        // Верхняя часть
        renderLine(builder, matrix, x, y + height, z, x + width, y + height, z, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y + height, z, x + width, y + height, z + depth, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y + height, z + depth, x, y + height, z + depth, r, g, b, alpha);
        renderLine(builder, matrix, x, y + height, z + depth, x, y + height, z, r, g, b, alpha);

        // Соединения между уровнями
        renderLine(builder, matrix, x, y, z, x, y + height, z, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y, z, x + width, y + height, z, r, g, b, alpha);
        renderLine(builder, matrix, x + width, y, z + depth, x + width, y + height, z + depth, r, g, b, alpha);
        renderLine(builder, matrix, x, y, z + depth, x, y + height, z + depth, r, g, b, alpha);
    }

    private static void renderLine(VertexConsumer builder, Matrix4f matrix, double x1, double y1, double z1, double x2, double y2, double z2, float r, float g, float b, float alpha) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;

        float length = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);

        float nx = (float) (dx / length);
        float ny = (float) (dy / length);
        float nz = (float) (dz / length);

        builder.addVertex(matrix, (float) x1, (float) y1, (float) z1).setColor(r, g, b, alpha).setNormal(nx, ny, nz);
        builder.addVertex(matrix, (float) x2, (float) y2, (float) z2).setColor(r, g, b, alpha).setNormal(nx, ny, nz);
    }


}
