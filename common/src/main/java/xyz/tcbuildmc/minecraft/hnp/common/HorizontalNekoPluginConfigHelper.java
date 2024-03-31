package xyz.tcbuildmc.minecraft.hnp.common;

import xyz.tcbuildmc.common.config.ConfigHelper;

import java.nio.file.Paths;

public final class HorizontalNekoPluginConfigHelper extends ConfigHelper {
    public HorizontalNekoPluginConfigHelper(Class<?> clazz) {
        super(Paths.get("./plugins/HorizontalNekoPlugin/config.toml"),
                clazz,
                "config.toml");
    }
}
