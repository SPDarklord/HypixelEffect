package com.coco_gigpn.fr;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import Menu.RotationMenu;
import Utils.Configuration;
import Utils.Filtre.RotationType;

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
			Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + " §4error will disable configuration file!");
		}

		
	}
	
	@Override
	public void onDisable() {
			Bukkit.getServer().getConsoleSender().sendMessage(PREFIX + " §bis now §4disable");
		
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
			RotationMenu.openMainGui(p);
		}}}		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (!e.getInventory().getName().equals(HypixelEffect.config.hypixeleffectInvMainPrefix.replace("&", "§")) && !e.getInventory().getName().equals(HypixelEffect.config.hypixeleffectInvSpiralPrefix.replace("&", "§")) && !e.getInventory().getName().equals(HypixelEffect.config.hypixeleffectInvTornadoPrefix.replace("&", "§")) && !e.getInventory().getName().equals(HypixelEffect.config.hypixeleffectInvRadarPrefix.replace("&", "§"))) return;
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
	Configuration c = HypixelEffect.config;
	switch (e.getCurrentItem().getType()) {
	case REDSTONE:
		if (p.hasPermission("hypixeleffect.use.heart") || p.hasPermission("hypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.CAT_PURREOW, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryHeart.replace("&", "§"))) {
		Utils.Filtre.filtre(p,RotationType.ROTATION, "HEART", HypixelEffect.config.radius, false);
		} 
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectHeart.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case NOTE_BLOCK:
		if (p.hasPermission("hypixeleffect.use.note")|| p.hasPermission("hypixeleffect.use.*")) {
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryMusic.replace("&", "§"))) {
		Utils.Filtre.filtre(p,RotationType.ROTATION, "NOTE", HypixelEffect.config.radius, true);
		}
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectMusic.replace("&", "§"));
		} else {
            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
          }
	    break;
	case BLAZE_POWDER:
		if (p.hasPermission("hypixeleffect.use.flame")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryFlame.replace("&", "§"))) {
		Utils.Filtre.filtre(p, RotationType.ROTATION, "FLAME", HypixelEffect.config.radius, false);
		} }  else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.flamespiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryFlameSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "FLAME", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.flameradar")|| p.hasPermission("hypixeleffect.use.*")) {
		    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryFlameRadar.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.RADAR, "FLAME", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.flametornado")|| p.hasPermission("hypixeleffect.use.*")) {
		    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryFlameTornado.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.TORNADO, "FLAME", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectFlame.replace("&", "§"));
	    break;
	case WATER:
		if (p.hasPermission("hypixeleffect.use.water")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWater.replace("&", "§"))) {
		Utils.Filtre.filtre(p , RotationType.ROTATION, "DRIP_WATER", HypixelEffect.config.radius, false);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.watespiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWaterSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "DRIP_WATER", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.waterradar")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWaterRadar.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.RADAR, "DRIP_WATER", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.watertornado")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWaterTornado.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.TORNADO, "DRIP_WATER", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.WATER, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectWater.replace("&", "§"));
	    break;
	case LAVA:
		if (p.hasPermission("hypixeleffect.use.lava")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryLava.replace("&", "§"))) {
		Utils.Filtre.filtre(p, RotationType.ROTATION, "DRIP_LAVA", HypixelEffect.config.radius, false);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.lavaspiral")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryLavaSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "DRIP_LAVA", HypixelEffect.config.radius, false);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.lavaradar")|| p.hasPermission("hypixeleffect.use.*")) {
	    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryLavaRadar.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.RADAR, "DRIP_LAVA", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.lavatornado")|| p.hasPermission("hypixeleffect.use.*")) {
		    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryLavaTornado.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.TORNADO, "DRIP_LAVA", HypixelEffect.config.radius, false);
			} } else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectLava.replace("&", "§"));
	
	    break;
	case NETHER_STAR:
		if (p.hasPermission("hypixeleffect.use.spark")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySpark.replace("&", "§"))) {
		Utils.Filtre.filtre(p, RotationType.ROTATION,  "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.sparkspiral") || p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySparkSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.sparkradar") || p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySparkRadar.replace("&", "§"))) {
		
			Utils.Filtre.filtre(p, RotationType.RADAR, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
		} } else  {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.sparktornador") || p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySparkTornado.replace("&", "§"))) {
			
				Utils.Filtre.filtre(p, RotationType.TORNADO, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
			} } else  {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSpark.replace("&", "§"));
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIZZ, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
	    break;
	case BOOK:
		if (p.hasPermission("hypixeleffect.use.witch")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWitch.replace("&", "§"))) {
		Utils.Filtre.filtre(p, RotationType.ROTATION, "WITCH_MAGIC", HypixelEffect.config.radius, false);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.witchspiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWitchSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "WITCH_MAGIC", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.witchradar")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWitchRadar.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.RADAR, "WITCH_MAGIC", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.witchtornado")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryWitchTornado.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.TORNADO, "WITCH_MAGIC", HypixelEffect.config.radius, false);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectWitch.replace("&", "§"));  
	    break;
	case INK_SACK:
		if (p.hasPermission("hypixeleffect.use.smoke")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySmoke.replace("&", "§"))) {
		Utils.Filtre.filtre(p, RotationType.ROTATION, "RED_DUST", HypixelEffect.config.radius, true);
		} } else {
			 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		} 
		if (p.hasPermission("hypixeleffect.use.smokespiral")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySmokeSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "RED_DUST", HypixelEffect.config.radius, true);
		}
		} else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.smokeradar")|| p.hasPermission("hypixeleffect.use.*")) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySmokeRadar.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.RADAR, "RED_DUST", HypixelEffect.config.radius, true);
		} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.smoketornado")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySmokeTornado.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.TORNADO, "RED_DUST", HypixelEffect.config.radius, true);
			} } else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.PIG_IDLE, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		p.closeInventory();
		p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSmoke.replace("&", "§"));
	    break;
	case REDSTONE_BLOCK:
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		Utils.Maths.stopRotation(p);
		p.closeInventory();
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryStop.replace("&", "§"))) {
		p.sendMessage(HypixelEffect.config.hypixeleffectStop.replace("&", "§"));
		}
	    break;
	case SUGAR:
		if (p.hasPermission("hypixeleffect.use.snowspiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySnowSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
			} } else {
		            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		if (p.hasPermission("hypixeleffect.use.snowradar")|| p.hasPermission("hypixeleffect.use.*")) {	
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySnowRadar.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.RADAR, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
			} } else {
				 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (p.hasPermission("hypixeleffect.use.snowtornado")|| p.hasPermission("hypixeleffect.use.*")) {	
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySnowTornado.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.TORNADO, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
			} } else {
				 p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
		if (HypixelEffect.config.specialSounds) 
			p.playSound(p.getLocation(), Sound.STEP_SNOW, 1, 1);
		else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			p.closeInventory();
			p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSnow.replace("&", "§"));
			break;
	case QUARTZ:
		if (p.hasPermission("hypixeleffect.use.cloudspiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryCloudSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "CLOUD", HypixelEffect.config.radius, false);
			} } else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		if (p.hasPermission("hypixeleffect.use.cloud")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryCloud.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.ROTATION, "CLOUD", HypixelEffect.config.radius, false);
			} } else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
		if (p.hasPermission("hypixeleffect.use.cloudradar")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryCloudRadar.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.RADAR, "CLOUD", HypixelEffect.config.radius, false);
			} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		    }
		if (p.hasPermission("hypixeleffect.use.cloudtornado")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryCloudTornado.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.TORNADO, "CLOUD", HypixelEffect.config.radius, false);
			} } else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		    }
			if (HypixelEffect.config.specialSounds) 
				p.playSound(p.getLocation(), Sound.EAT, 1, 1);
			else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			p.closeInventory();
			p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectCloud.replace("&", "§"));
			break;
	case SPIDER_EYE: 
		if (p.hasPermission("hypixeleffect.use.spellspiral")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySpellSpiral.replace("&", "§"))) {
			Utils.Filtre.filtre(p, RotationType.SPIRAL, "MOB_SPELL", HypixelEffect.config.radius, true);
			} } else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
			if (p.hasPermission("hypixeleffect.use.spellradar")|| p.hasPermission("hypixeleffect.use.*")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySpellRadar.replace("&", "§"))) {
				Utils.Filtre.filtre(p, RotationType.RADAR, "MOB_SPELL", HypixelEffect.config.radius, true);
			}} else {
			p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		}
			if (p.hasPermission("hypixeleffect.use.spelltornado")|| p.hasPermission("hypixeleffect.use.*")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventorySpellTornado.replace("&", "§"))) {
					Utils.Filtre.filtre(p, RotationType.TORNADO, "MOB_SPELL", HypixelEffect.config.radius, true);
				}} else {
				p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
			}
			if (HypixelEffect.config.specialSounds) 
				p.playSound(p.getLocation(), Sound.EAT, 1, 1);
			else p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			p.closeInventory();
			p.sendMessage(HypixelEffect.config.hypixeleffectActivate.replace("&", "§") + HypixelEffect.config.hypixeleffectSpell.replace("&", "§"));
			break;
	case PAPER:
		if (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryPageSpiral.replace("&", "§"))) {
			Menu.SpiralMenu.openSpiralGUI(p);
		} else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryPageRadar.replace("&", "§"))) {
			Menu.RadarMenu.openRadarGUI(p);
		} else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryPageTornado.replace("&", "§"))) {
			Menu.TornadoMenu.openTornadoGUI(p);
		}  else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(c.hypixelInventoryPageMain.replace("&", "§"))) {
			Menu.RotationMenu.openMainGui(p);
		} 
		break;
	default:   
		p.closeInventory();
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
	        	  RotationMenu.openMainGui(p);
	          
	          } else {
	            p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
	          }
	        } else if (args.length == 1) {
	        	
	       if ((args[0].equalsIgnoreCase("reload")) && (p.hasPermission("hypixeleffect.reload")))
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
	       
	        }  else if (args[0].equalsIgnoreCase("heart")) {
	        		if (p.hasPermission("hypixeleffect.use.heart") || (p.hasPermission("hypixeleffect.use.*"))) {
	        			Utils.Filtre.filtre(p, RotationType.ROTATION, "HEART", HypixelEffect.config.radius, false);
	        } } else if (args[0].equalsIgnoreCase("note")) {
        		if (p.hasPermission("hypixeleffect.use.note") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.ROTATION, "NOTE", HypixelEffect.config.radius, true);
        }  
        } else if (args[0].equalsIgnoreCase("flame")) {
    		if (p.hasPermission("hypixeleffect.use.flame") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "FLAME", HypixelEffect.config.radius, false);
    		}
    		
        } else if (args[0].equalsIgnoreCase("water")) {
    		if (p.hasPermission("hypixeleffect.use.water") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "DRIP_water", HypixelEffect.config.radius, false);
    		}
        } else if (args[0].equalsIgnoreCase("lava")) {
    		if (p.hasPermission("hypixeleffect.use.lava") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "DRIP_LAVA", HypixelEffect.config.radius, false);
    		}
        } else if (args[0].equalsIgnoreCase("spark")) {
    		if (p.hasPermission("hypixeleffect.use.flame") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "SPARK", HypixelEffect.config.radius, false);
    		}
        } else if (args[0].equalsIgnoreCase("witch")) {
    		if (p.hasPermission("hypixeleffect.use.witch") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "WITCH_MAGIC", HypixelEffect.config.radius, false);
    		}
        } else if (args[0].equalsIgnoreCase("smoke")) {
    		if (p.hasPermission("hypixeleffect.use.smoke") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "RED_DUST", HypixelEffect.config.radius, true);
    		} 
        } else if (args[0].equalsIgnoreCase("cloud")) {
    		if (p.hasPermission("hypixeleffect.use.cloud") || (p.hasPermission("hypixeleffect.use.*"))) {
    			Utils.Filtre.filtre(p, RotationType.ROTATION, "CLOUD", HypixelEffect.config.radius, false);
    		}
        } else if (args[0].equalsIgnoreCase("stop")) {
        	Utils.Maths.stopRotation(p);
        }
        
	       if (!Utils.Filtre.HasPermission(p)) {
		    	  p.sendMessage(HypixelEffect.config.hypixeleffectPermission.replace("&", "§"));
		      }
	        } else if (args.length == 2) {
	        if (args[0].equalsIgnoreCase("snow") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.snowspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("cloud") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.cloudspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "CLOUD", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("flame") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.flamespiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "FLAME", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("water") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.waterspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "DRIP_WATER", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("lava") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.lavaspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "DRIP_LAVA", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spark") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.sparkspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("witch") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.witchspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "WITCH_MAGIC", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("smoke") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.smokespiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "RED_DUST", HypixelEffect.config.radius, true);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spell") && args[1].equalsIgnoreCase("spiral")) {
        		if (p.hasPermission("hypixeleffect.use.spellspiral") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.SPIRAL, "spell", HypixelEffect.config.radius, false);
        		  } 
        		
        		
	        } else if (args[0].equalsIgnoreCase("snow") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.snowradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("cloud") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.cloudradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "CLOUD", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("flame") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.flameradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "FLAME", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("water") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.waterradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "DRIP_WATER", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("lava") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.lavaradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "DRIP_LAVA", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spark") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.sparkradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("witch") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.witchradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "WITCH_MAGIC", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("smoke") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.smokeradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "RED_DUST", HypixelEffect.config.radius, true);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spell") && args[1].equalsIgnoreCase("radar")) {
        		if (p.hasPermission("hypixeleffect.use.spellradar") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.RADAR, "spell", HypixelEffect.config.radius, false);
        		  } 
	        } 
	        
	        
	        else if (args[0].equalsIgnoreCase("snow") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.snowtornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "SNOW_SHOVEL", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("cloud") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.cloudtornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "CLOUD", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("flame") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.flametornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "FLAME", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("water") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.watertornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "DRIP_WATER", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("lava") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.lavatornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "DRIP_LAVA", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spark") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.sparktornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "FIREWORKS_SPARK", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("witch") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.witchtornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "WITCH_MAGIC", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("smoke") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.smoketornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "RED_DUST", HypixelEffect.config.radius, true);
        		  } 
	        } else if (args[0].equalsIgnoreCase("spell") && args[1].equalsIgnoreCase("tornado")) {
        		if (p.hasPermission("hypixeleffect.use.spelltornado") || (p.hasPermission("hypixeleffect.use.*"))) {
        			Utils.Filtre.filtre(p, RotationType.TORNADO, "spell", HypixelEffect.config.radius, false);
        		  } 
	        } else if (args[0].equalsIgnoreCase("stop") && args[1].equalsIgnoreCase(args[1])) {
	        	if (p.hasPermission("hypixeleffect.stopother")) {
	        		 Player target = Bukkit.getServer().getPlayer(args[1]);
	                 if (target == null) {
	                         p.sendMessage(ChatColor.RED + "Player " + args[0] + " not found !");
	                         return true;
	                 }
	                 Utils.Maths.stopRotation(target);
	        	}
	        }
       
	        }
	    } }
	    return false;
	  }
	

}
