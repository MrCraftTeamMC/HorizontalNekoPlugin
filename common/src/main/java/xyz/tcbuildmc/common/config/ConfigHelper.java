package xyz.tcbuildmc.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;

@Getter
public abstract class ConfigHelper {
    private final CommentedFileConfig config;

    public ConfigHelper(Path path, URL defaultConfig) {
        this.config = CommentedFileConfig.builder(path)
                .defaultData(defaultConfig)
                .autosave()
                .build();
    }

    public ConfigHelper(Path path, ClassLoader loader, String defaultConfigName) {
        this(path, loader.getResource(defaultConfigName));
    }

    public ConfigHelper(Path path, Class<?> clazz, String defaultConfigName) {
        this(path, clazz.getClassLoader(), defaultConfigName);
    }

    public <T> T getContent(String path) {
        return this.config.get(path);
    }

    public void setContent(String path, Object object) {
        this.config.set(path, object);
    }

    public void addContent(String path, Object object) {
        this.config.add(path, object);
    }

    public void removeContent(String path) {
        this.config.remove(path);
    }

    public void setComment(String path, String comment) {
        this.config.setComment(path, comment);
    }

    public void removeComment(String path) {
        this.config.removeComment(path);
    }

    public Map<String, Object> getContentMap() {
        return this.config.valueMap();
    }

    public Map<String, String> getCommentMap() {
        return this.config.commentMap();
    }

    public File getConfigFile() {
        return this.config.getFile();
    }

    public Path getConfigPath() {
        return this.config.getNioPath();
    }

    public void load() {
        this.config.load();
    }

    @Deprecated(forRemoval = true)
    public void reload() {
        this.load();
    }

    @Deprecated(forRemoval = true)
    public void save() {
        this.config.save();
    }

    public void close() {
        this.config.close();
    }
}
