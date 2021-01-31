
package net.mcreator.boss_tools.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.boss_tools.item.Tier3RocketItemItem;
import net.mcreator.boss_tools.BossToolsModElements;

@BossToolsModElements.ModElement.Tag
public class BossToolsItemGroup extends BossToolsModElements.ModElement {
	public BossToolsItemGroup(BossToolsModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabboss_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Tier3RocketItemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
