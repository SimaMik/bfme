package net.sima.bfme.entity.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.sima.bfme.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class Eagle extends TamableAnimal implements PlayerRideable {
    public final AnimationState flyAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public Eagle(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.EAGLE.get().create(pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.25d, 18f, 7f, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1d));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 4f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 35D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.FLYING_SPEED, 0.25D) // Добавляем скорость полета
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        Item itemForTaming = Items.APPLE;

        if (item == itemForTaming && !isTame()) {
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (!ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                    super.tame(pPlayer);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                    setOrderedToSit(true);
                    this.setInSittingPose(true);
                }

                return InteractionResult.SUCCESS;
            }
        }

        if (isTame() && (pHand == InteractionHand.MAIN_HAND) && !isFood(itemstack)) {
            if (!pPlayer.isCrouching()) {
                setRiding(pPlayer);
            } else {
                setOrderedToSit(!isOrderedToSit());
                setInSittingPose(!isOrderedToSit());
            }
            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(pPlayer, pHand);
    }
    private void setRiding(Player pPlayer) {
        this.setInSittingPose(false);

        pPlayer.setYRot(this.getYRot() + 5);
        pPlayer.setXRot(this.getXRot());
        pPlayer.startRiding(this);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return ((LivingEntity) this.getFirstPassenger());
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pLivingEntity) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() != Direction.Axis.Y) {
            int[][] offsets = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (Pose pose : pLivingEntity.getDismountPoses()) {
                AABB aabb = pLivingEntity.getLocalBoundsForPose(pose);

                for (int[] offset : offsets) {
                    blockpos$mutableblockpos.set(blockpos.getX() + offset[0], blockpos.getY(), blockpos.getZ() + offset[1]);
                    double d0 = this.level().getBlockFloorHeight(blockpos$mutableblockpos);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutableblockpos, d0);
                        if (DismountHelper.canDismountTo(this.level(), pLivingEntity, aabb.move(vec3))) {
                            pLivingEntity.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(pLivingEntity);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if(this.isNoGravity() || this.isFallFlying()){
            this.flyAnimationState.start(this.tickCount);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }


    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isVehicle() && getControllingPassenger() instanceof Player) {
            LivingEntity controllingPassenger = this.getControllingPassenger();
            this.setYRot(controllingPassenger.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(controllingPassenger.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.yBodyRot;
            float strafe = controllingPassenger.xxa * 0.5F;
            float forward = controllingPassenger.zza;

            // Check if the controlling passenger is pressing the jump key
            boolean isJumping = Minecraft.getInstance().options.keyJump.isDown();

            // If the player is pressing the jump key, increase the vertical motion
            if (isJumping) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, 1, 0)); // Adjust the vertical speed as needed
                this.setNoGravity(true);
                this.flyAnimationState.start(this.tickCount); // Начало анимации полета
            } else {
                if (this.isNoGravity()) {
                    this.setNoGravity(false);
                    this.flyAnimationState.stop(); // Остановка анимации полета
                }
            }

            if (this.isControlledByLocalInstance()) {
                float speed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);
                if (Minecraft.getInstance().options.keySprint.isDown()) {
                    speed *= 2f; // Adjust the speed boost as needed
                }

                this.setSpeed(speed);
                super.travel(new Vec3(strafe, this.getDeltaMovement().y, forward));

                // Apply gravity manually for smooth flight
                this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.35, 1));
            } else {
                super.travel(pTravelVector);
            }
        } else {
            super.travel(pTravelVector);
        }
    }
    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }
}
