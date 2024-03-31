package xyz.tcbuildmc.minecraft.hnp.bungeecord;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.tcbuildmc.minecraft.hnp.common.HorizontalNekoPluginConfigHelper;

@Getter
public final class HorizontalNekoPlugin extends Plugin {
    private static HorizontalNekoPlugin instance;
    private static HorizontalNekoPluginConfigHelper config;

    public HorizontalNekoPlugin() {
        HorizontalNekoPlugin.instance = this;
        HorizontalNekoPlugin.config = new HorizontalNekoPluginConfigHelper(HorizontalNekoPlugin.class);
    }

    @Override
    public void onEnable() {
        config.load();
    }

    @Override
    public void onDisable() {
        config.close();
    }
}
