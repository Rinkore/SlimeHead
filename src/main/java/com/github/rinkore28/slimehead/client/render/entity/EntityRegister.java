package com.github.rinkore28.slimehead.client.render.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class EntityRegister {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("entitytesting", "cube"), "main");

    public static void init() {
        /*
         * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
         *
         * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
         */

        EntityRendererRegistry.register(com.github.rinkore28.slimehead.core.registry.entities.EntityRegister.CUBE, (context) -> {
            return new CubeEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
    }
}