package me.spywhere.DebuggerSample;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class DebuggerSample extends JavaPlugin implements Listener{ 
	private Logger log=Logger.getLogger("Minecraft");
	private PluginDescriptionFile pdf=null;
	DebuggerConnector dc=null;

	public void onEnable() {
		pdf=this.getDescription();
		getServer().getPluginManager().registerEvents(this, this);
		dc = new DebuggerConnector(getServer().getPluginManager(),pdf);
		if(dc.isConnected()){
			//Debugger Connected.
			log.info("["+pdf.getName()+"] Debugger plugin found.");	
		}
		if(dc.Console("Hello, World!")){
			//Send successfully.
		}else{
			//Failed to send. Connect to Debugger failed.
		}
		log.info("["+pdf.getName()+"] v"+pdf.getVersion()+" successfully enabled.");
	}

	public void onDisable() {
		log.info("["+pdf.getName()+"] v"+pdf.getVersion()+" successfully disabled.");
	}
	
	@EventHandler
	public final void onBlockPlace(BlockPlaceEvent event) {
		//If breakpoint is set, cancel the event.
		if(dc.isBreak("msg")){event.setCancelled(true);}
		if(event.getBlockPlaced().getType()==Material.TORCH){
			event.getPlayer().sendMessage("Torch Placed!!!");
		}
	}
}