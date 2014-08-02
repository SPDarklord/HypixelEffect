package Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.coco_gigpn.fr.HypixelEffect;

public class TornadoMenu {
	
	final public static HashMap<Player, Inventory> gui4 = new HashMap<Player, Inventory>();
	static List<String> lore4 = new ArrayList<String>();
	private static String statut4 = "";
	
	public static void openTornadoGUI(Player p) {
		
		if(!gui4.containsKey(p))  {
		
		Inventory inv4 = Bukkit.createInventory(null, (36),
				HypixelEffect.config.hypixeleffectInvTornadoPrefix.replace("&", "§"));
		gui4.put(p, inv4);

		
		ItemStack snowT = new ItemStack(Material.SUGAR);
		ItemStack cloudT = new ItemStack(Material.QUARTZ);
		ItemStack flameT = new ItemStack(Material.BLAZE_POWDER);
		ItemStack waterT = new ItemStack(Material.WATER);
		ItemStack lavaT = new ItemStack(Material.LAVA);
		ItemStack sparkT = new ItemStack(Material.NETHER_STAR);
		ItemStack witchT = new ItemStack(Material.BOOK);
		ItemStack smokeT = new ItemStack(Material.INK_SACK);
		ItemStack spellT = new ItemStack(Material.SPIDER_EYE);
		
		ItemStack page = new ItemStack(Material.PAPER);
		
		ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK);

		ItemMeta snowTMeta = snowT.getItemMeta();
		ItemMeta cloudTMeta = cloudT.getItemMeta();
		ItemMeta flameTMeta = flameT.getItemMeta();
		ItemMeta waterTMeta = waterT.getItemMeta();
		ItemMeta lavaTMeta = lavaT.getItemMeta();
		ItemMeta sparkTMeta = sparkT.getItemMeta();
		ItemMeta witchTMeta = witchT.getItemMeta();
		ItemMeta smokeTMeta = smokeT.getItemMeta();
		ItemMeta spellTMeta = spellT.getItemMeta();
		
		ItemMeta pageMeta = page.getItemMeta();

		ItemMeta stopMeta = stop.getItemMeta();

		snowTMeta.setDisplayName(HypixelEffect.config.hypixelInventorySnowTornado.replace("&", "§"));
		cloudTMeta.setDisplayName(HypixelEffect.config.hypixelInventoryCloudTornado.replace("&", "§"));
		flameTMeta.setDisplayName(HypixelEffect.config.hypixelInventoryFlameTornado.replace("&", "§"));
		waterTMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWaterTornado.replace("&", "§"));
		lavaTMeta.setDisplayName(HypixelEffect.config.hypixelInventoryLavaTornado.replace("&", "§"));
		sparkTMeta.setDisplayName(HypixelEffect.config.hypixelInventorySparkTornado.replace("&", "§"));
		witchTMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWitchTornado.replace("&", "§"));
		smokeTMeta.setDisplayName(HypixelEffect.config.hypixelInventorySmokeTornado.replace("&", "§"));
		spellTMeta.setDisplayName(HypixelEffect.config.hypixelInventorySpellTornado.replace("&", "§"));
		
		pageMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageRadar
				.replace("&", "§"));
		pageMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		
		if (Utils.Filtre.HasEffect(p)) {
			statut4 = HypixelEffect.config.hypixeleffectInvStatutOn.replace("&", "§");
		} else {
			statut4 = HypixelEffect.config.hypixeleffectInvStatutOff.replace("&", "§");
		}
		lore4.clear();
		lore4.add(HypixelEffect.config.hypixeleffectInvStatutPrefix + " "
				+ statut4);
		stopMeta.setLore(lore4);
		stopMeta.setDisplayName(HypixelEffect.config.hypixelInventoryStop.replace("&", "§"));
		
		snowT.setItemMeta(snowTMeta);
		cloudT.setItemMeta(cloudTMeta);
		flameT.setItemMeta(flameTMeta);
		waterT.setItemMeta(waterTMeta);
		lavaT.setItemMeta(lavaTMeta);
		sparkT.setItemMeta(sparkTMeta);
		witchT.setItemMeta(witchTMeta);
		smokeT.setItemMeta(smokeTMeta);
		spellT.setItemMeta(spellTMeta);
		
		page.setItemMeta(pageMeta);
		
		stop.setItemMeta(stopMeta);
			
			inv4.setItem(0, snowT);
			inv4.setItem(1, spellT);
			inv4.setItem(2, flameT);
			inv4.setItem(3, waterT);
			inv4.setItem(4, lavaT);
			inv4.setItem(5, sparkT);
			inv4.setItem(6, witchT);
			inv4.setItem(7, smokeT);
			inv4.setItem(8, cloudT);
			
			inv4.setItem(28, page);
			
			inv4.setItem(27, stop);
			for (Player pInv : gui4.keySet()) {
			pInv.openInventory(inv4);
			gui4.remove(p);
			}
			
			
	
	
	} 
	}

}
