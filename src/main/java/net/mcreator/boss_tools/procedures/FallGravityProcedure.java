package net.mcreator.boss_tools.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.boss_tools.entity.RocketTier3Entity;
import net.mcreator.boss_tools.entity.RocketTier2Entity;
import net.mcreator.boss_tools.entity.RocketEntity;
import net.mcreator.boss_tools.entity.LandingGearEntity;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.BossToolsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

@BossToolsModElements.ModElement.Tag
public class FallGravityProcedure extends BossToolsModElements.ModElement {
	public FallGravityProcedure(BossToolsModElements instance) {
		super(instance, 487);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure FallGravity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BossToolsMod.LOGGER.warn("Failed to load dependency x for procedure FallGravity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BossToolsMod.LOGGER.warn("Failed to load dependency y for procedure FallGravity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BossToolsMod.LOGGER.warn("Failed to load dependency z for procedure FallGravity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure FallGravity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("boss_tools:moon_biom")))
				|| ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
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
																		.equals(new ResourceLocation("boss_tools:orbit_mercury_biom")))))))))) {
			if (((entity.getMotion().getY()) <= (-0.01))) {
				entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.05), (entity.getMotion().getZ()));
				entity.fallDistance = (float) (0.2);
			}
			if (((entity.getMotion().getY()) >= 0.08)) {
				entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.05), (entity.getMotion().getZ()));
				entity.fallDistance = (float) (0.2);
			}
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (192 / 2d), y - (192 / 2d), z - (192 / 2d), x + (192 / 2d), y + (192 / 2d), z + (192 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof ItemEntity)) {
						if (((entityiterator.getMotion().getY()) <= (-0.1))) {
							if (((entityiterator.getPersistentData().getDouble("ItemGravity")) <= 1)) {
								entityiterator.getPersistentData().putDouble("ItemGravity", 2);
								entityiterator.setMotion((entityiterator.getMotion().getX()), ((entityiterator.getMotion().getY()) + 0.04),
										(entityiterator.getMotion().getZ()));
								entityiterator.getPersistentData().putDouble("ItemGravity", 0);
							}
						}
					}
				}
			}
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (192 / 2d), y - (192 / 2d), z - (192 / 2d), x + (192 / 2d), y + (192 / 2d), z + (192 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((!(entityiterator instanceof PlayerEntity))) {
						if ((!(entityiterator instanceof RocketEntity.CustomEntity))) {
							if ((!(entityiterator instanceof LandingGearEntity.CustomEntity))) {
								if ((!(entityiterator instanceof RocketEntity.CustomEntity))) {
									if ((!(entityiterator instanceof RocketTier2Entity.CustomEntity))) {
										if ((!(entityiterator instanceof RocketTier3Entity.CustomEntity))) {
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator).addPotionEffect(
														new EffectInstance(Effects.SLOW_FALLING, (int) 120, (int) 1, (false), (false)));
										}
									}
								}
							}
						}
					}
				}
			}
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
