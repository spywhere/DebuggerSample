package me.spywhere.DebuggerSample;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class DebuggerSample extends JavaPlugin{ 
	private Logger log=Logger.getLogger("Minecraft");
	private PluginDescriptionFile pdf=null;
	DebuggerConnector dc=null;

	public void onEnable() {
		pdf=this.getDescription();
		dc = new DebuggerConnector(getServer().getPluginManager(),pdf);
		if(dc.isConnected()){
			//Debugger Connected
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
}