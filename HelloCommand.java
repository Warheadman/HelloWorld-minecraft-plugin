package me.warhead.helloworld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.warhead.helloworld.Main;

public class HelloCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public HelloCommand(Main plugin){
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Only Player may execute this command");
			return true;
		}
		Player p = (Player) sender;
		
		if (p.hasPermission("hello.use")){
			p.sendMessage("hi!");
			return true;
		} else {
			p.sendMessage("You Dont Have Permissions To Do That!");
		}
		return false;
	}
	
}
