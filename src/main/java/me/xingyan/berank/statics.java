package me.xingyan.berank;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class statics {

    public static boolean getperms(Player player, String permission){
        return Bukkit.getPlayer(player.getName()).hasPermission(permission);
    }

    public static boolean isonline(String player){
        return Bukkit.getPlayer(player).isOnline();
    }
    public static Player getpbyname(String player){
        return Bukkit.getPlayer(player);
    }

}
