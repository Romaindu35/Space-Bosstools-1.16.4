package net.mcreator.boss_tools.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class PlayerMovementOnPotionActiveTickProcedure extends BossToolsModElements.ModElement {
	public PlayerMovementOnPotionActiveTickProcedure(BossToolsModElements instance) {
		super(instance, 530);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerMovementOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.08), (entity.getMotion().getZ()));
	}
}
