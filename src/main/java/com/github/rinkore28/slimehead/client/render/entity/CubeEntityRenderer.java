package com.github.rinkore28.slimehead.client.render.entity;

import com.github.rinkore28.slimehead.core.registry.entities.CubeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * 一个用来提供模型、阴影大小和纹理的渲染器
 */
public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {

    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(EntityRegister.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("slimehead", "textures/entity/slimehead/mikko_ayaka.png");
    }
}