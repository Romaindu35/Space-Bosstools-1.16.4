package net.mcreator.boss_tools.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class OxygenArmorBodyTickEventProcedure extends BossToolsModElements.ModElement {
	public OxygenArmorBodyTickEventProcedure(BossToolsModElements instance) {
		super(instance, 190);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BossToolsMod.LOGGER.warn("Failed to load dependency itemstack for procedure OxygenArmorBodyTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).setDamage((int) 1);
	}
}
