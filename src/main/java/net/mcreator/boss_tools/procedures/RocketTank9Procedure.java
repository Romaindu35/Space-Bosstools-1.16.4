package net.mcreator.boss_tools.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class RocketTank9Procedure extends BossToolsModElements.ModElement {
	public RocketTank9Procedure(BossToolsModElements instance) {
		super(instance, 271);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure RocketTank9!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getPersistentData().getDouble("fuel")) >= 153);
	}
}
