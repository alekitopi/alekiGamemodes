package es.alekitopi.alekigamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    Main plugin;

    public GamemodeCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Settings lang = Main.getLang();
        if(!sender.hasPermission("agm.gamemode")){
            sender.sendMessage(Utils.chat(lang.getString("noperms")));
            return true;
        }

        if(args.length < 1){
            sender.sendMessage(Utils.chat(lang.getString("usage")));
            return true;
        }

        String mode;
        switch (args[0]) {
            case "0":
            case "s":
            case "survival":
                mode = "SURVIVAL";
                break;
            case "1":
            case "c":
            case "creative":
                mode = "CREATIVE";
                break;
            case "2":
            case "a":
            case "adventure":
                mode = "ADVENTURE";
                break;
            case "3":
            case "spectator":
                mode = "SPECTATOR";
                break;
            default:
                sender.sendMessage(Utils.chat(lang.getString("usage")));
                return true;
        }

        if(!sender.hasPermission("agm.gamemode."+mode.toLowerCase())){
            sender.sendMessage(Utils.chat(lang.getString("noperms")));
            return true;
        }

        if (args.length == 1) {
            if(sender instanceof Player){
                ((Player) sender).setGameMode(GameMode.valueOf(mode));
                sender.sendMessage(Utils.chat(lang.getString("changed").replace("{mode}", lang.getString("modes."+mode.toLowerCase()))));
            } else {
                sender.sendMessage(Utils.chat(lang.getString("onlyplayer")));
                return true;
            }
        } else if (args.length == 2) {
            Player target = Bukkit.getServer().getPlayer(args[1]);
            if(target.isOnline()){
                target.setGameMode(GameMode.valueOf(mode));
                target.sendMessage(Utils.chat(lang.getString("changed").replace("{mode}", lang.getString("modes."+mode.toLowerCase()))));
                sender.sendMessage(Utils.chat(lang.getString("changedother").replace("{player}", target.getDisplayName()).replace("{mode}", lang.getString("modes."+mode.toLowerCase()))));
            } else {
                sender.sendMessage(Utils.chat(lang.getString("playeroffline")));
            }
        }

        return true;
    }
}
