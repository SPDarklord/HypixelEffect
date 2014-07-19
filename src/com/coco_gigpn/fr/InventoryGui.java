package com.coco_gigpn.fr;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryGui {

	final public static HashMap<Player, Inventory> gui = new HashMap<Player, Inventory>();
	
	public static void openGUI(Player p) {
		
		if(!gui.containsKey(p))  {
		
		Inventory inv = Bukkit.createInventory(null, 9,
				HypixelEffect.config.hypixeleffectInvPrefix.replace("&", "§"));
		gui.put(p, inv);

		ItemStack heart = new ItemStack(Material.REDSTONE);
		ItemStack music = new ItemStack(Material.NOTE_BLOCK);
		ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
		ItemStack water = new ItemStack(Material.WATER);
		ItemStack lava = new ItemStack(Material.LAVA);
		ItemStack spark = new ItemStack(Material.SUGAR);
		ItemStack witch = new ItemStack(Material.WRITTEN_BOOK);
		ItemStack snow = new ItemStack(Material.SNOW);
		ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK);

		ItemMeta heartMeta = heart.getItemMeta();
		ItemMeta musicMeta = music.getItemMeta();
		ItemMeta flameMeta = flame.getItemMeta();
		ItemMeta waterMeta = water.getItemMeta();
		ItemMeta lavaMeta = lava.getItemMeta();
		ItemMeta sparkMeta = spark.getItemMeta();
		ItemMeta witchMeta = witch.getItemMeta();
		ItemMeta snowMeta = snow.getItemMeta();
		ItemMeta stopMeta = stop.getItemMeta();
		

		heartMeta.setDisplayName(HypixelEffect.config.hypixelInventoryHeart.replace("&", "§"));
		musicMeta.setDisplayName(HypixelEffect.config.hypixelInventoryMusic.replace("&", "§"));
		flameMeta.setDisplayName(HypixelEffect.config.hypixelInventoryFlame.replace("&", "§"));
		waterMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWater.replace("&", "§"));
		lavaMeta.setDisplayName(HypixelEffect.config.hypixelInventoryLava.replace("&", "§"));
		sparkMeta.setDisplayName(HypixelEffect.config.hypixelInventorySpark.replace("&", "§"));
		witchMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWitch.replace("&", "§"));
		snowMeta.setDisplayName(HypixelEffect.config.hypixelInventorySnow.replace("&", "§"));
		stopMeta.setDisplayName(HypixelEffect.config.hypixelInventoryStop.replace("&", "§"));

		heart.setItemMeta(heartMeta);
		music.setItemMeta(musicMeta);
		flame.setItemMeta(flameMeta);
		water.setItemMeta(waterMeta);
		lava.setItemMeta(lavaMeta);
		spark.setItemMeta(sparkMeta);
		witch.setItemMeta(witchMeta);
		snow.setItemMeta(snowMeta);
		stop.setItemMeta(stopMeta);
	

		if (HypixelEffect.config.disableItem) {
			if (p.hasPermission("hypixeleffect.use.heart")) {
				inv.setItem(HypixelEffect.config.positionHeart, heart);
			}
			if (p.hasPermission("hypixeleffect.use.note")) {
				inv.setItem(HypixelEffect.config.positionMusic, music);
			}
			if (p.hasPermission("hypixeleffect.use.flame")) {
				inv.setItem(HypixelEffect.config.positionFlame, flame);
			}
			if (p.hasPermission("hypixeleffect.use.water")) {
				inv.setItem(HypixelEffect.config.positionWater, water);
			}
			if (p.hasPermission("hypixeleffect.use.lava")) {
				inv.setItem(HypixelEffect.config.positionLava, lava);
			}
			if (p.hasPermission("hypixeleffect.use.spark")) {
				inv.setItem(HypixelEffect.config.positionSpark, spark);
			}
			if (p.hasPermission("hypixeleffect.use.witch")) {
				inv.setItem(HypixelEffect.config.positionWitch, witch);
			}
			if (p.hasPermission("hypixeleffect.use.snow")) {
				inv.setItem(HypixelEffect.config.positionSnow, snow);
			}
			if (p.hasPermission("hypixeleffect.use.stop")) {
				inv.setItem(HypixelEffect.config.positionStop, stop);
			}
			

			if (p.hasPermission("hypixeleffect.use.*") && !p.isOp()) {
				inv.setItem(HypixelEffect.config.positionHeart, heart);
				inv.setItem(HypixelEffect.config.positionMusic, music);
				inv.setItem(HypixelEffect.config.positionFlame, flame);
				inv.setItem(HypixelEffect.config.positionWater, water);
				inv.setItem(HypixelEffect.config.positionLava, lava);
				inv.setItem(HypixelEffect.config.positionSpark, spark);
				inv.setItem(HypixelEffect.config.positionWitch, witch);
				inv.setItem(HypixelEffect.config.positionSnow, snow);
				inv.setItem(HypixelEffect.config.positionStop, stop);
			}
			
			for (Player pInv : gui.keySet()) {
				pInv.openInventory(inv);
				gui.remove(p);
				}
			
			
		} else {
			inv.setItem(HypixelEffect.config.positionHeart, heart);
			inv.setItem(HypixelEffect.config.positionMusic, music);
			inv.setItem(HypixelEffect.config.positionFlame, flame);
			inv.setItem(HypixelEffect.config.positionWater, water);
			inv.setItem(HypixelEffect.config.positionLava, lava);
			inv.setItem(HypixelEffect.config.positionSpark, spark);
			inv.setItem(HypixelEffect.config.positionWitch, witch);
			inv.setItem(HypixelEffect.config.positionSnow, snow);
			inv.setItem(HypixelEffect.config.positionStop, stop);
			for (Player pInv : gui.keySet()) {
			pInv.openInventory(inv);
			gui.remove(p);
			}
			
			
	
	} 
	} 
	}
}
