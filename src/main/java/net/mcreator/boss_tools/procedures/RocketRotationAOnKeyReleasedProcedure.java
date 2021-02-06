package net.mcreator.boss_tools.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.entity.RocketTier3Entity;
import net.mcreator.boss_tools.entity.RocketTier2Entity;
import net.mcreator.boss_tools.entity.RocketEntity;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class RocketRotationAOnKeyReleasedProcedure extends BossToolsModElements.ModElement {
	public RocketRotationAOnKeyReleasedProcedure(BossToolsModElements instance) {
		super(instance, 370);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure RocketRotationAOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getRidingEntity()) instanceof RocketEntity.CustomEntity)) {
			(entity.getRidingEntity()).getPersistentData().putDouble("Rotation", 0);
		}
		if (((entity.getRidingEntity()) instanceof RocketTier2Entity.CustomEntity)) {
			(entity.getRidingEntity()).getPersistentData().putDouble("Rotation", 0);
		}
		if (((entity.getRidingEntity()) instanceof RocketTier3Entity.CustomEntity)) {
			(entity.getRidingEntity()).getPersistentData().putDouble("Rotation", 0);
		}
	}
}
