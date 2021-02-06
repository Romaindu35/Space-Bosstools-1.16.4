
package net.mcreator.boss_tools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.boss_tools.itemgroup.BossToolsItemGroup;
import net.mcreator.boss_tools.BossToolsModElements;

@BossToolsModElements.ModElement.Tag
public class BucketBigItem extends BossToolsModElements.ModElement {
	@ObjectHolder("boss_tools:bucket_big")
	public static final Item block = null;
	public BucketBigItem(BossToolsModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BossToolsItemGroup.tab).maxStackSize(8).rarity(Rarity.COMMON));
			setRegistryName("bucket_big");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
