package net.mcreator.boss_tools.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class AlienOnEntityTickUpdateProcedure extends BossToolsModElements.ModElement {
	public AlienOnEntityTickUpdateProcedure(BossToolsModElements instance) {
		super(instance, 110);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure AlienOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BossToolsMod.LOGGER.warn("Failed to load dependency x for procedure AlienOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BossToolsMod.LOGGER.warn("Failed to load dependency y for procedure AlienOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BossToolsMod.LOGGER.warn("Failed to load dependency z for procedure AlienOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure AlienOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName() != null
				&& world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName().equals(new ResourceLocation("boss_tools:moon_biom")))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 60, (int) 1, (false), (false)));
		}
		if ((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName() != null
				&& world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName().equals(new ResourceLocation("boss_tools:mars_biom")))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 60, (int) 1, (false), (false)));
		}
		if ((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName() != null
				&& world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getRegistryName()
						.equals(new ResourceLocation("boss_tools:orbit_overworld_biom")))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 60, (int) 1, (false), (false)));
		}
	}
}
