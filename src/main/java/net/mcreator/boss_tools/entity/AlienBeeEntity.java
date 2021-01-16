
package net.mcreator.boss_tools.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.boss_tools.procedures.AlienBeeOnEntityTickUpdateProcedure;
import net.mcreator.boss_tools.itemgroup.BossToolsItemGroup;
import net.mcreator.boss_tools.BossToolsModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumSet;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@BossToolsModElements.ModElement.Tag
public class AlienBeeEntity extends BossToolsModElements.ModElement {
	public static EntityType entity = null;
	public AlienBeeEntity(BossToolsModElements instance) {
		super(instance, 9);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.6f)).build("alien_bee")
						.setRegistryName("alien_bee");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16750849, -16777063, new Item.Properties().group(BossToolsItemGroup.tab))
				.setRegistryName("alien_bee_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelalienbee(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("boss_tools:textures/alienbee.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Blocks.OAK_LEAVES, (int) (1)));
			this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.DIAMOND, (int) (1)));
			this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Blocks.DEAD_BUSH, (int) (1)));
			this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Blocks.POPPY, (int) (1)));
			this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Items.QUARTZ, (int) (1)));
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.IRON_NUGGET, (int) (1)));
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}
				public boolean shouldExecute() {
					if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
							&& CustomEntity.this.getAttackTarget().isAlive();
				}

				@Override
				public void startExecuting() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					Vector3d vec3d = livingentity.getEyePosition(1);
					CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.7);
				}

				@Override
				public void tick() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
						CustomEntity.this.attackEntityAsMob(livingentity);
					} else {
						double d0 = CustomEntity.this.getDistanceSq(livingentity);
						if (d0 < 16) {
							Vector3d vec3d = livingentity.getEyePosition(1);
							CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.7);
						}
					}
				}
			});
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1.5, 20) {
				@Override
				protected Vector3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vector3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.8, false));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.targetSelector.addGoal(8, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beehive.work"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bee.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bee.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				AlienBeeOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelalienbee extends EntityModel<Entity> {
		private final ModelRenderer Bee;
		private final ModelRenderer Flgel1;
		private final ModelRenderer Flgel2;
		public Modelalienbee() {
			textureWidth = 64;
			textureHeight = 64;
			Bee = new ModelRenderer(this);
			Bee.setRotationPoint(-3.0F, 21.0F, -6.0F);
			Bee.setTextureOffset(24, 44).addBox(-1.0F, -8.0F, 0.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
			Bee.setTextureOffset(0, 0).addBox(1.0F, -7.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 0).addBox(5.0F, -7.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 62).addBox(5.0F, 0.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 62).addBox(5.0F, 0.0F, 7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 60).addBox(5.0F, 1.0F, 8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 60).addBox(5.0F, 1.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 62).addBox(1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 62).addBox(1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 60).addBox(1.0F, 1.0F, 8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 60).addBox(1.0F, 1.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 0).addBox(1.0F, -8.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 0).addBox(5.0F, -8.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Bee.setTextureOffset(0, 57).addBox(3.0F, -4.0F, 12.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
			Flgel1 = new ModelRenderer(this);
			Flgel1.setRotationPoint(4.0F, 14.0F, -1.0F);
			Flgel1.setTextureOffset(9, 24).addBox(-1.0F, 0.0F, -3.0F, 7.0F, 0.0F, 6.0F, 0.0F, false);
			Flgel2 = new ModelRenderer(this);
			Flgel2.setRotationPoint(-4.0F, 14.0F, -1.0F);
			Flgel2.setTextureOffset(2, 18).addBox(-6.0F, 0.0F, -3.0F, 7.0F, 0.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Bee.render(matrixStack, buffer, packedLight, packedOverlay);
			Flgel1.render(matrixStack, buffer, packedLight, packedOverlay);
			Flgel2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Flgel1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.Flgel2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
