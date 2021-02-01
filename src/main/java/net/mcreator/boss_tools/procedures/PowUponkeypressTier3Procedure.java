package net.mcreator.boss_tools.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.potion.RocketpotionPotion;
import net.mcreator.boss_tools.entity.RocketTier3Entity;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;
import java.util.Collection;

@BossToolsModElements.ModElement.Tag
public class PowUponkeypressTier3Procedure extends BossToolsModElements.ModElement {
	public PowUponkeypressTier3Procedure(BossToolsModElements instance) {
		super(instance, 333);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure PowUponkeypressTier3!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BossToolsMod.LOGGER.warn("Failed to load dependency x for procedure PowUponkeypressTier3!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BossToolsMod.LOGGER.warn("Failed to load dependency y for procedure PowUponkeypressTier3!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BossToolsMod.LOGGER.warn("Failed to load dependency z for procedure PowUponkeypressTier3!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure PowUponkeypressTier3!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RocketpotionPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check((entity.getRidingEntity()))) == (false))) {
			if (((entity.getRidingEntity()) instanceof RocketTier3Entity.CustomEntity)) {
				if ((((entity.getRidingEntity()).getPersistentData().getDouble("fuel")) == 400)) {
					if ((entity.getRidingEntity()) instanceof LivingEntity)
						((LivingEntity) (entity.getRidingEntity()))
								.addPotionEffect(new EffectInstance(RocketpotionPotion.potion, (int) 99999, (int) 13, (false), (false)));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("boss_tools:rocketfly")),
								SoundCategory.NEUTRAL, (float) 3, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("boss_tools:rocketfly")),
								SoundCategory.NEUTRAL, (float) 3, (float) 1, false);
					}
					(entity.getRidingEntity()).getPersistentData().putDouble("Powup", 1);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(
										"\u00A7cNO FUEL! \u00A77Fill the Rocket with \u00A7cFuel\u00A77. (\u00A76Sneak and Right Click\u00A77)"),
								(false));
					}
				}
			}
		}
	}
}
