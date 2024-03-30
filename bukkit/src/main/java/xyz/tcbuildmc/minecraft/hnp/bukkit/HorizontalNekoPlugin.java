package xyz.tcbuildmc.minecraft.hnp.bukkit;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.minecraft.hnp.bukkit.command.HorizontalNekoCommands;
import xyz.tcbuildmc.minecraft.hnp.common.HorizontalNekoPluginConfigHelper;

@Getter
public final class HorizontalNekoPlugin extends JavaPlugin {
    private static HorizontalNekoPlugin instance;
    private static HorizontalNekoPluginConfigHelper config;

    public HorizontalNekoPlugin() {
        HorizontalNekoPlugin.instance = this;
        HorizontalNekoPlugin.config = new HorizontalNekoPluginConfigHelper(HorizontalNekoPlugin.class);
    }

    @Override
    public void onLoad() {
        // CommandAPI Initialize
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true));

        HorizontalNekoCommands.register();
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable();

        config.load();
    }

    @Override
    public void onDisable() {
        config.close();

        CommandAPI.onDisable();
    }
}
