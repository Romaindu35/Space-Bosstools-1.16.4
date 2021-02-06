package net.mcreator.boss_tools.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.item.OrbitPlacerItem;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class SpaceStationIronLogicProcedure extends BossToolsModElements.ModElement {
	public SpaceStationIronLogicProcedure(BossToolsModElements instance) {
		super(instance, 380);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure SpaceStationIronLogic!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(OrbitPlacerItem.block, (int) (1)))
				: false);
	}
}
