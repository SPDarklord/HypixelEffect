package com.coco_gigpn.fr;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import Utils.Configuration;

public class HypixelEffect extends JavaPlugin implements Listener {

	public static Configuration config;
	public static HypixelEffect plugin;
	public static final String PREFIX = "§8[§3HypixelEffect§8]";
	
	@Override
	public void onEnable() {
		try {
			config = new Configuration(new File(this.getDataFolder(), "config.yml"));
			config.load();
			HypixelEffect.plugin = this;
			Bukkit.getPluginManager().registerEvents(this, this);
			Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + " §bis now §2enable !");
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@Override
	public void onDisable() {
	
		try {
			config.save();
			Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + " §bis now §4disable");
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("hypixeleffect.itemjoin")) {
			if (HypixelEffect.config.itemOnJoin) {
				
				ItemStack hypixelchest = new ItemStack(Material.CHEST, 1);
				ItemMeta hypixelchestMeta = hypixelchest.getItemMeta();
				hypixelchestMeta.setDisplayName(HypixelEffect.config.hypixeleffectPrefix.replace("&", "§"));
				hypixelchest.setItemMeta(hypixelchestMeta);
				
				if (p.getInventory().contains(hypixelchest)) {
					return;
				} else {
				p.getInventory().addItem(hypixelchest);
				}
				
			}
		}
	}
	
	
	 @EventHandler
	 public void OnPlayerLeft(PlayerQuitEvent e) {
		 Player p = e.getPlayer();
		 if (Utils.Maths.countdown_id.containsKey(p)) {
			 Utils.Maths.stopRotation(p);
		 }
	 }
	
	@EventHandler
	public void OnplayerInteract(PlayerInteractEvent e) {
		
		
		Action a = e.getAction();
		ItemStack is = e.getItem();
		Player p = e.getPlayer();
		
		ItemStack hypixelchest = new ItemStack(Material.CHEST, 1);
		ItemMeta hypixelchestMeta = hypixelchest.getItemMeta();
		hypixelchestMeta.setDisplayName(HypixelEffect.config.hypixeleffectPrefix.replace("&", "§"));
		hypixelchest.setItemMeta(hypixelchestMeta);
		
		if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR || hypixelchest == null) return;

		if (e.getItem().equals(hypixelchest)) {
			e.setCancelled(true);
		if (p.hasPermission("hypixeleffect.open")) {
		if (e.getItem().getItemMeta().equals(hypixelchestMeta)) {
			InventoryGui.openGUI(p);
		}}}		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (!e.getInventory().getName().equals(HypixelEffect.config.hypixeleffectInvPrefix.replace("&", "§"))) return;
		Player p = (Player) e.getWhoClicked(); 
		e.setCancelled(true);
	
		if (p.hasPermission("hypixeleffect.open")) {
	if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
		p.closeInventory();
		p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
		return;
	} 
		} else {
	        p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
	      }
	
	switch (e.getCurrentItem().getType()) {
	case REDSTONE:
		if (p.hasPermission("hypixeleffect.use.heart") || p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.CAT_PURREOW, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "HEART", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectHeart.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case NOTE_BLOCK:
		if (p.hasPermission("hypixeleffect.use.note")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "NOTE", HypixelEffect.config.radius, true);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectMusic.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case BLAZE_POWDER:
		if (p.hasPermission("hypixeleffect.use.flame")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "FLAME", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectFlame.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case WATER:
		if (p.hasPermission("hypixeleffect.use.water")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.WATER, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "DRIP_WATER", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectWater.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case LAVA:
		if (p.hasPermission("hypixeleffect.use.lava")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "DRIP_LAVA", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectLava.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case SUGAR:
		if (p.hasPermission("hypixeleffect.use.spark")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSpark.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case WRITTEN_BOOK:
		if (p.hasPermission("hypixeleffect.use.witch")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Filtre.filtre(p, "WITCH_MAGIC", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectWitch.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case SNOW:
		if (p.hasPermission("hypixeleffect.use.snow")|| p.hasPermission("Hhypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.STEP_SNOW, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
	
		Utils.Filtre.filtre(p, "SNOWBALL_POOF", HypixelEffect.config.radius, false);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSnow.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case REDSTONE_BLOCK:
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Maths.stopRotation(p);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectStop.replace("&", "§"));
	    break;
	default:   
		p.closeInventory();
		p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
		break;
		
	}
	
	}
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if ((sender instanceof Player))
	    {
	      Player p = (Player)sender;
	      if ((cmd.getName().equalsIgnoreCase("hypixeleffect")) || (cmd.getName().equalsIgnoreCase("he"))) {
	        if (args.length == 0)
	        {
	          if ((p.hasPermission("hypixeleffect.use")) || (p.isOp())) {
	        	  InventoryGui.openGUI(p);
	          
	          } else {
	            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
	          }
	        }
	        else if ((args[0].equalsIgnoreCase("reload")) && (p.hasPermission("hypixeleffect.reload")))
	        {
	         try {
				HypixelEffect.config.load();
				Utils.Maths.stopRotation(p);
				p.sendMessage(HypixelEffect.config.hypixeleffectReload.replace("&", "§"));
				Utils.Maths.countdown_id.clear();
			} catch (InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        } 
	        else if ((args[0].equalsIgnoreCase("menu")) && (p.hasPermission("hypixeleffect.menu")))
	        {
	        	ItemStack hypixelchest = new ItemStack(Material.CHEST, 1);
				ItemMeta hypixelchestMeta = hypixelchest.getItemMeta();
				hypixelchestMeta.setDisplayName(HypixelEffect.config.hypixeleffectPrefix.replace("&", "§"));
				hypixelchest.setItemMeta(hypixelchestMeta);
				if (! p.getInventory().contains(hypixelchest)) {
					 p.getInventory().addItem(hypixelchest);
				} else {
					return true;
				}
	       
	        }
	      }
	    }
	    return false;
	  }
	
	
	
}
