package Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.coco_gigpn.fr.HypixelEffect;

public class RotationMenu {
	final public static HashMap<Player, Inventory> gui = new HashMap<Player, Inventory>();
	static List<String> lore = new ArrayList<String>();
	private static String statut2 = "";

	public static void openMainGui(Player p) {

		if (!gui.containsKey(p)) {

			Inventory inv = Bukkit.createInventory(null, (36),
					HypixelEffect.config.hypixeleffectInvMainPrefix.replace(
							"&", "§"));
			gui.put(p, inv);

			ItemStack heart = new ItemStack(Material.REDSTONE);
			ItemStack music = new ItemStack(Material.NOTE_BLOCK);
			ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
			ItemStack water = new ItemStack(Material.WATER);
			ItemStack lava = new ItemStack(Material.LAVA);
			ItemStack spark = new ItemStack(Material.NETHER_STAR);
			ItemStack witch = new ItemStack(Material.BOOK);
			ItemStack smoke = new ItemStack(Material.INK_SACK);
			ItemStack cloud = new ItemStack(Material.QUARTZ);
			
			ItemStack info = new ItemStack(Material.SKULL_ITEM);
			
			ItemStack page = new ItemStack(Material.PAPER);

			ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK);

			ItemMeta heartMeta = heart.getItemMeta();
			ItemMeta musicMeta = music.getItemMeta();
			ItemMeta flameMeta = flame.getItemMeta();
			ItemMeta waterMeta = water.getItemMeta();
			ItemMeta lavaMeta = lava.getItemMeta();
			ItemMeta sparkMeta = spark.getItemMeta();
			ItemMeta witchMeta = witch.getItemMeta();
			ItemMeta smokeMeta = smoke.getItemMeta();
			ItemMeta cloudMeta = cloud.getItemMeta();
			
			ItemMeta infoMeta = info.getItemMeta();
			
			ItemMeta pageMeta = page.getItemMeta();

			ItemMeta stopMeta = stop.getItemMeta();

			heartMeta.setDisplayName(HypixelEffect.config.hypixelInventoryHeart
					.replace("&", "§"));
			musicMeta.setDisplayName(HypixelEffect.config.hypixelInventoryMusic
					.replace("&", "§"));
			flameMeta.setDisplayName(HypixelEffect.config.hypixelInventoryFlame
					.replace("&", "§"));
			waterMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWater
					.replace("&", "§"));
			lavaMeta.setDisplayName(HypixelEffect.config.hypixelInventoryLava
					.replace("&", "§"));
			sparkMeta.setDisplayName(HypixelEffect.config.hypixelInventorySpark
					.replace("&", "§"));
			witchMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWitch
					.replace("&", "§"));
			smokeMeta.setDisplayName(HypixelEffect.config.hypixelInventorySmoke
					.replace("&", "§"));
			cloudMeta.setDisplayName(HypixelEffect.config.hypixelInventoryCloud
					.replace("&", "§"));
			
			infoMeta.setDisplayName(HypixelEffect.config.hypixeleffectInvInfo
					.replace("&", "§") + " " + Utils.Maths.countdown_id.size());
			
			pageMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageSpiral
					.replace("&", "§"));

			stopMeta.setDisplayName(HypixelEffect.config.hypixelInventoryStop
					.replace("&", "§"));
			if (Utils.Filtre.HasEffect(p)) {
				statut2 = HypixelEffect.config.hypixeleffectInvStatutOn.replace("&", "§");
			} else {
				statut2 = HypixelEffect.config.hypixeleffectInvStatutOff.replace("&", "§");
			}
			lore.clear();
			lore.add(HypixelEffect.config.hypixeleffectInvStatutPrefix.replace("&", "§") + " "
					+ statut2);
			stopMeta.setLore(lore);

			heart.setItemMeta(heartMeta);
			music.setItemMeta(musicMeta);
			flame.setItemMeta(flameMeta);
			water.setItemMeta(waterMeta);
			lava.setItemMeta(lavaMeta);
			spark.setItemMeta(sparkMeta);
			witch.setItemMeta(witchMeta);
			smoke.setItemMeta(smokeMeta);
			cloud.setItemMeta(cloudMeta);
			
			info.setItemMeta(infoMeta);
			
			page.setItemMeta(pageMeta);
			

			stop.setItemMeta(stopMeta);

			inv.setItem(0, heart);
			inv.setItem(1, music);
			inv.setItem(2, flame);
			inv.setItem(3, water);
			inv.setItem(4, lava);
			inv.setItem(5, spark);
			inv.setItem(6, witch);
			inv.setItem(7, smoke);
			inv.setItem(8, cloud);

			if (HypixelEffect.config.playersUsing) {
				inv.setItem(31, info);
			}
			inv.setItem(35, page);
			
			inv.setItem(27, stop);
			for (Player pInv : gui.keySet()) {
				pInv.openInventory(inv);
				gui.remove(p);
			}

		}
	}


}
