package net.mcreator.boss_tools.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.boss_tools.potion.BulletGeneratorPotion;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.Map;
import java.util.Collection;

@BossToolsModElements.ModElement.Tag
public class SpaceArmorBodyTickEventProcedure extends BossToolsModElements.ModElement {
	public SpaceArmorBodyTickEventProcedure(BossToolsModElements instance) {
		super(instance, 153);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BossToolsMod.LOGGER.warn("Failed to load dependency itemstack for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BossToolsMod.LOGGER.warn("Failed to load dependency x for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BossToolsMod.LOGGER.warn("Failed to load dependency y for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BossToolsMod.LOGGER.warn("Failed to load dependency z for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == BulletGeneratorPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))) {
			if ((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("boss_tools:moon_biom")))
						|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY)
								.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
								&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
										.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
										.equals(new ResourceLocation("boss_tools:mars_biom")))
								|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY)
										.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
										&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
												.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
												.equals(new ResourceLocation("boss_tools:mercurybiome")))
										|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY)
												.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
												&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
														.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
														.equals(new ResourceLocation("boss_tools:orbit_overworld_biom")))
												|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY)
														.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
														&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
																.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
																.equals(new ResourceLocation("boss_tools:orbit_moon_biom")))
														|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY)
																.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
																&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
																		.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
																		.equals(new ResourceLocation("boss_tools:orbit_mars_biom")))
																|| (world.func_241828_r().getRegistry(Registry.BIOME_KEY)
																		.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
																		&& world.func_241828_r().getRegistry(Registry.BIOME_KEY)
																				.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
																				.equals(new ResourceLocation(
																						"boss_tools:orbit_mercury_biom")))))))))) {
					if ((((itemstack).getOrCreateTag().getDouble("Energy")) > 0)) {
						(itemstack).getOrCreateTag().putDouble("Energy", (((itemstack).getOrCreateTag().getDouble("Energy")) - 1));
						entity.getPersistentData().putBoolean("SpaceSuitC", (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("Energy")) < 1)) {
					entity.getPersistentData().putBoolean("SpaceSuitC", (false));
				}
				if ((((itemstack).getOrCreateTag().getDouble("Energy")) == 1000)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A761000 \u00A79Oxygen!"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A761000 \u00A79Oxygen!"), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("Energy")) == 1)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A760 \u00A79Oxygen!"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A760 \u00A79Oxygen!"), (true));
					}
				}
			}
		}
	}
}
