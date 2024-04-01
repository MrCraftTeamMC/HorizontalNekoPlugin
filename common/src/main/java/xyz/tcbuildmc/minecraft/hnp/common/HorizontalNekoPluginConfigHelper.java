package xyz.tcbuildmc.minecraft.hnp.common;

import xyz.tcbuildmc.common.config.ConfigHelper;

public final class HorizontalNekoPluginConfigHelper extends ConfigHelper {
    public HorizontalNekoPluginConfigHelper(Class<?> clazz) {
        super("./plugins/HorizontalNekoPlugin/config.toml", clazz);
    }
}
