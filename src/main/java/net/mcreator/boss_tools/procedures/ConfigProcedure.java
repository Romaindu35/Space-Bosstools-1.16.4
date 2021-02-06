package net.mcreator.boss_tools.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;

import net.mcreator.boss_tools.BossToolsModVariables;
import net.mcreator.boss_tools.BossToolsModElements;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

@BossToolsModElements.ModElement.Tag
public class ConfigProcedure extends BossToolsModElements.ModElement {
	public ConfigProcedure(BossToolsModElements instance) {
		super(instance, 521);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		double config = 0;
		String testconfig = "";
		String titleconfig = "";
		String alienhouseconfig = "";
		String Meteor = "";
		String oxygen = "";
		File boss_tools = new File(((System.getProperty("user.dir")) + "" + ("//config/")) + "/" + "Space-Bosstools-Config.toml");
		try {
			final BufferedReader boss_toolsReader = new BufferedReader(new FileReader(boss_tools));
			String boss_toolsReadLine = null;
			boss_toolsReadLine = boss_toolsReader.readLine();
			titleconfig = (String) (boss_toolsReadLine);
			boss_toolsReader.close();
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		if ((!(((titleconfig)).equals("# Space-Bosstools config #")))) {
			try {
				FileWriter boss_toolswriter = new FileWriter(boss_tools);
				BufferedWriter boss_toolsbw = new BufferedWriter(boss_toolswriter);
				boss_toolsbw.write("# Space-Bosstools config #");
				boss_toolsbw.newLine();
				boss_toolsbw.write("Alien Spawn = true");
				boss_toolsbw.newLine();
				boss_toolsbw.write("Alien House Structure = true");
				boss_toolsbw.newLine();
				boss_toolsbw.write("Meteor Structure = true");
				boss_toolsbw.newLine();
				boss_toolsbw.write("Oxygen System = true");
				boss_toolsbw.close();
				boss_toolswriter.close();
			} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} // logic Alien Spawn
		try {
			final BufferedReader boss_toolsReader = new BufferedReader(new FileReader(boss_tools));
			String boss_toolsReadLine = null;
			boss_toolsReadLine = boss_toolsReader.readLine();
			titleconfig = (String) (boss_toolsReadLine);
			boss_toolsReadLine = boss_toolsReader.readLine();
			testconfig = (String) (boss_toolsReadLine);
			boss_toolsReadLine = boss_toolsReader.readLine();
			alienhouseconfig = (String) (boss_toolsReadLine);
			boss_toolsReadLine = boss_toolsReader.readLine();
			Meteor = (String) (boss_toolsReadLine);
			boss_toolsReadLine = boss_toolsReader.readLine();
			oxygen = (String) (boss_toolsReadLine);
			boss_toolsReader.close();
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		if ((((testconfig)).equals("Alien Spawn = true"))) {
			BossToolsModVariables.Config = (double) 1;
		}
		if ((!(((testconfig)).equals("Alien Spawn = true")))) {
			BossToolsModVariables.Config = (double) 2;
		} // logic Alien House
		if ((((alienhouseconfig)).equals("Alien House Structure = true"))) {
			BossToolsModVariables.Configalienhouse = (double) 1;
		}
		if ((!(((alienhouseconfig)).equals("Alien House Structure = true")))) {
			BossToolsModVariables.Configalienhouse = (double) 2;
		} // logic Meteor
		if ((((Meteor)).equals("Meteor Structure = true"))) {
			BossToolsModVariables.ConfigMeteor = (double) 1;
		}
		if ((!(((Meteor)).equals("Meteor Structure = true")))) {
			BossToolsModVariables.ConfigMeteor = (double) 2;
		} // logic oxygen System
		if ((((oxygen)).equals("Oxygen System = true"))) {
			BossToolsModVariables.oxygen_system = (double) 1;
		}
		if ((!(((oxygen)).equals("Oxygen System = true")))) {
			BossToolsModVariables.oxygen_system = (double) 2;
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		this.executeProcedure(Collections.emptyMap());
	}
}
