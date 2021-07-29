package me.xingyan.berank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;


import java.util.UUID;

import static me.xingyan.berank.statics.*;

public class berank implements CommandExecutor {

    String usage = ChatColor.RED+"Usage: /berank <beplayer> <rank>";
    String noperm = ChatColor.RED+"Sorry but u don't have permission to use this command.";
    String ponly = ChatColor.RED+"Player Only Command";
    String nobeplayer = ChatColor.RED+"This Player Is Not Bedrock Edition Player.";




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(getperms(player, "berank.use")){
                if(args.length==0){
                    player.sendMessage(usage);
                    return false;
                }
                if(args.length==2){
                    if(isonline(args[0])){
                        UUID UUID = getpbyname(args[0]).getUniqueId();
                        if(FloodgateApi.getInstance().isFloodgatePlayer(UUID)){
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user "+UUID.toString()+" parent set "+args[1]);
                            return true;
                        }else{
                            player.sendMessage(nobeplayer);
                        }
                        return false;
                    }
                }
            }else{
                player.sendMessage(noperm);
                return false;
            }
        }else{
            sender.sendMessage(ponly);
        }


        return false;
    }



}
