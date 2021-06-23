package es.alekitopi.alekigamemodes;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Settings {

    private FileConfiguration config;
    private File file;
    private Main u;

    public Settings(Main u, String s) {
        this.u = u;
        this.file = new File(this.u.getDataFolder(), s + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
        Reader reader = new InputStreamReader(u.getResource(s + ".yml"), StandardCharsets.UTF_8);
        YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(reader);
        try {
            if (!this.file.exists()) {
                this.config.addDefaults(loadConfiguration);
                this.config.options().copyDefaults(true);
                this.config.save(this.file);
            } else {
                this.config.addDefaults(loadConfiguration);
                this.config.options().copyDefaults(true);
                this.config.save(this.file);
                this.config.load(this.file);
            }
        } catch (IOException | InvalidConfigurationException ignored) {
        }
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException ignored) {
        }
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public String getString(String s) {
        return this.config.getString(s);
    }

    public int getInt(String s) {
        return this.config.getInt(s);
    }

    public List<String> getList(String s) {
        return this.config.getStringList(s);
    }

    public boolean isSet(String s) {
        return this.config.isSet(s);
    }

    public void set(String s, Object o) {
        this.config.set(s, o);
    }

    public boolean getBoolean(String s) {
        return this.config.getBoolean(s);
    }
}
