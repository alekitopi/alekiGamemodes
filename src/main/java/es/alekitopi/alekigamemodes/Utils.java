package es.alekitopi.alekigamemodes;

import net.md_5.bungee.api.ChatColor;

public class Utils {

    static String prefix = "";

    public static String chat(String msg){
        if(msg.contains("{prefix}")) {
            msg = msg.replace("{prefix}", prefix);
        }
        if(msg.contains("{aleki}")) {
            msg = msg.replace("{aleki}", "&4&la&c&ll&6&le&e&lk&2&li&a&lt&b&lo&3&lp&1&li");
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
