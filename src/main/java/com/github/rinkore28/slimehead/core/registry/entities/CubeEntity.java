package com.github.rinkore28.slimehead.core.registry.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

/*
 * 我们创建的实体继承自 PathAwareEntity, 它继承自 MobEntity, 而 MobEntity 继承自 LivingEntity.
 *
 * LivingEntity 拥有生命值，并且可以造成伤害。
 * MobEntity 具有AI逻辑和移动控制。
 * PathAwareEntity 提供额外的寻路系统，很多AI任务都需要用到寻路。
 */
public class CubeEntity extends PathAwareEntity {
    public CubeEntity(EntityType<? extends CubeEntity> slimehead, World world) {
        super(slimehead, world);
    }
    public static DefaultAttributeContainer.Builder createCubeAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        this.goalSelector.add(3, new TemptGoal(this, 12.5, Ingredient.ofItems(Items.PLAYER_HEAD), false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15f, 1.0f);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET)) {
            this.dead = true;
            player.playSound(SoundEvents.ENTITY_SNIFFER_DROP_SEED, 1.0f, 1.0f);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, Items.PLAYER_HEAD.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            this.discard();
            return ActionResult.success(this.getWorld().isClient);
        }
        return super.interactMob(player, hand);
    }


    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.95f;
    }

    public static boolean checkCubeSpawnRules(WorldAccess world
            , SpawnReason spawnReason
            , BlockPos blockPos
            , Random random) {
        return true;
    }


}