package drunk.republica.devteam;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class drukenBitch extends JavaPlugin implements Listener{
	

	private static drukenBitch instance;
	private PotionEffect drank = new PotionEffect(PotionEffectType.CONFUSION, 1000, 4);
	
	public drukenBitch() {
		super();
		instance = this;
	}
	
	public static Logger getInstanceLogger() {
		return instance.getLogger();
	}
	
	public void onEnable(){
		getLogger().info("Plugin Enabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
 
	public void onDisable(){
		getLogger().info("Plugin Disabled!");
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e){
		
		if(e.getPlayer().getItemInHand().getTypeId() == 335){
			e.getPlayer().addPotionEffect(drank);
		}
		
	}
	
	
}
