package es.alekitopi.alekigamemodes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Settings config;
    private static Settings language;

    @Override
    public void onEnable() {
        log("&5Cargando idioma...");
        language = new Settings(this, "lang");
        Utils.prefix = language.getString("prefix");

        log("&5Cargando comandos...");
        this.getCommand("gamemode").setExecutor(new GamemodeCommand(this));
    }

    public void log(String msg){
        Bukkit.getConsoleSender().sendMessage(Utils.chat("&6aGamemodes &f"+msg));
    }

    public static Settings getLang(){
        return language;
    }
}
