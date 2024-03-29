package xyz.tcbuildmc.minecraft.hnp;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.minecraft.hnp.command.HorizontalNekoCommands;

public final class HorizontalNekoPlugin extends JavaPlugin {
    @Override
    public void onLoad() {
        // CommandAPI Initialize
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true));

        HorizontalNekoCommands.register();
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable();

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();

        saveConfig();
    }
}
