package me.spywhere.DebuggerSample;

import me.spywhere.Debugger.Debugger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;

public class DebuggerConnector {
	private Debugger debug=null;
	private PluginManager pm=null;
	PluginDescriptionFile pdf=null;
	
	public DebuggerConnector(PluginManager ipm,PluginDescriptionFile ipdf){
		pm=ipm;
		pdf=ipdf;
		if(pm.getPlugin("Debugger")!=null){
			debug=(Debugger)pm.getPlugin("Debugger");
		}
	}
	
	public boolean isConnected(){
		return (debug!=null);
	}
	
	public boolean Console(String msg,String id){
		if(isConnected()&&debug.isEnabled()){
			debug.sendConsole(pdf,id,msg);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Console(String msg){
		return Console(msg,"");
	}
	
	public boolean Chat(String msg,String id){
		if(isConnected()&&debug.isEnabled()){
			debug.sendChat(pdf,id,msg);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Chat(String msg){
			return Chat(msg,"");
	}
	
	public boolean RawChat(String msg,String id){
		if(isConnected()&&debug.isEnabled()){
			debug.sendRawChat(pdf,id,msg);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean RawChat(String msg){
		return RawChat(msg,"");
	}
}
