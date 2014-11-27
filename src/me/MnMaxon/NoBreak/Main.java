package me.MnMaxon.NoBreak;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		getServer().getPluginManager().registerEvents(new MainListener(), this);
	}
}