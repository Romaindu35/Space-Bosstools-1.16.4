package net.mcreator.boss_tools.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.potion.DamageRemovePotion;
import net.mcreator.boss_tools.potion.DamageRemove4Potion;
import net.mcreator.boss_tools.potion.DamageRemove3Potion;
import net.mcreator.boss_tools.potion.DamageRemove2Potion;
import net.mcreator.boss_tools.entity.RocketTier2Entity;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;
import java.util.HashMap;

@BossToolsModElements.ModElement.Tag
public class Rocket2OxygeneffectProcedure extends BossToolsModElements.ModElement {
	public Rocket2OxygeneffectProcedure(BossToolsModElements instance) {
		super(instance, 210);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure Rocket2Oxygeneffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getRidingEntity()) instanceof RocketTier2Entity.CustomEntity) == (true))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DamageRemovePotion.potion, (int) 2, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DamageRemove2Potion.potion, (int) 2, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DamageRemove3Potion.potion, (int) 2, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DamageRemove4Potion.potion, (int) 2, (int) 1, (false), (false)));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
