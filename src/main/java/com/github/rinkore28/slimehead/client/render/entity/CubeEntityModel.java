package com.github.rinkore28.slimehead.client.render.entity;

import com.github.rinkore28.slimehead.core.registry.entities.CubeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

public class CubeEntityModel extends EntityModel<CubeEntity> {

    private final ModelPart base;

    public CubeEntityModel(ModelPart modelPart) {
        base = modelPart.getChild(EntityModelPartNames.CUBE);
    }

    // 你可以使用 BlockBench，制作你的模型并为你的实体模型导出以得到这个方法。
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4F, 16F, -4F, 8F, 8F, 8F)
                , ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(CubeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}