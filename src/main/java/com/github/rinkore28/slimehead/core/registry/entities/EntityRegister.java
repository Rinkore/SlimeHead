package com.github.rinkore28.slimehead.core.registry.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class EntityRegister {

    /*
     * 使用“entitytesting:cube”作为ID注册我们的实体
     *
     * 这个实体注册在了 SpawnGroup#CREATURE 类别下，大多数的动物和友好或中立的生物都注册在这个类别下。
     * 它有一个 0.75 × 0.75（或12个像素宽，即一个方块的3/4）大小的碰撞体积。
     */

    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("slimehead", "mikkoayaka"),
            FabricEntityTypeBuilder.createMob()
                    .entityFactory(CubeEntity::new)
                    .defaultAttributes(CubeEntity::createCubeAttributes)
                    .spawnGroup(SpawnGroup.MONSTER)
                    .trackRangeChunks(10)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .spawnRestriction(SpawnRestriction.Location.NO_RESTRICTIONS
                            , Heightmap.Type.MOTION_BLOCKING_NO_LEAVES
                            , (slimehead, world, spawnReason, blockPos, random) -> CubeEntity.checkCubeSpawnRules(world, spawnReason, blockPos, random))
                    .build()
    );

    public static void init() {
        /*
         * 注册我们方块实体的默认属性。
         * 属性是一个生物当前状态的数值，其中有攻击伤害和生命值等。
         * 如果实体没有及时注册适当的属性，则游戏将崩溃。
         *
         * 在1.15中，它是通过重写实体类内部的方法来完成的。
         * 大部分的原版实体都有一个静态方法(例如,ZombieEntity#createZombieAttributes)用于初始化它们的属性。
         */
        FabricDefaultAttributeRegistry.register(
                CUBE, MobEntity.createMobAttributes()
        );
    }
}