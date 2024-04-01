package xyz.tcbuildmc.common.config;

import org.junit.jupiter.api.Test;

class ConfigHelperTest {
    private final String path = "./plugins/HorizontalNekoPlugin/config.toml";

    @Test
    public void getPath() {
        System.err.println(path.substring(path.lastIndexOf('/') + 1));
    }

    @Test
    public void getResource() {
        System.err.println(ConfigHelperTest.class
                .getClassLoader()
                .getResource("config.toml"));
    }
}