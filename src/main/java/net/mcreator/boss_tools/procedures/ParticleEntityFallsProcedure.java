package net.mcreator.boss_tools.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class ParticleEntityFallsProcedure extends BossToolsModElements.ModElement {
	public ParticleEntityFallsProcedure(BossToolsModElements instance) {
		super(instance, 122);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure ParticleEntityFalls!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 13, (int) 13));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) 0);
	}
}
