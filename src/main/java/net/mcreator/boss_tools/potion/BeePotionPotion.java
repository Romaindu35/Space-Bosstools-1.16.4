
package net.mcreator.boss_tools.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import net.mcreator.boss_tools.BossToolsModElements;

@BossToolsModElements.ModElement.Tag
public class BeePotionPotion extends BossToolsModElements.ModElement {
	@ObjectHolder("boss_tools:bee_potion")
	public static final Effect potion = null;
	public BeePotionPotion(BossToolsModElements instance) {
		super(instance, 205);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}
	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("bee_potion");
			potionIcon = new ResourceLocation("boss_tools:textures/noair.png");
		}

		@Override
		public String getName() {
			return "effect.bee_potion";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
