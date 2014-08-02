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

public class SpiralMenu {
	
	final public static HashMap<Player, Inventory> gui2 = new HashMap<Player, Inventory>();
	static List<String> lore2 = new ArrayList<String>();
	private static String statut2 = "";
	
	public static void openSpiralGUI(Player p) {
		
		if(!gui2.containsKey(p))  {
		
		Inventory inv2 = Bukkit.createInventory(null, (36),
				HypixelEffect.config.hypixeleffectInvSpiralPrefix.replace("&", "§"));
		gui2.put(p, inv2);

		
		ItemStack snowS = new ItemStack(Material.SUGAR);
		ItemStack cloudS = new ItemStack(Material.QUARTZ);
		ItemStack flameS = new ItemStack(Material.BLAZE_POWDER);
		ItemStack waterS = new ItemStack(Material.WATER);
		ItemStack lavaS = new ItemStack(Material.LAVA);
		ItemStack sparkS = new ItemStack(Material.NETHER_STAR);
		ItemStack witchS = new ItemStack(Material.BOOK);
		ItemStack smokeS = new ItemStack(Material.INK_SACK);
		ItemStack spellS = new ItemStack(Material.SPIDER_EYE);
		
		ItemStack page = new ItemStack(Material.PAPER);
		
		ItemStack pagereturn = new ItemStack(Material.PAPER);
		
		ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK);
		
		ItemMeta snowSMeta = snowS.getItemMeta();
		ItemMeta cloudSMeta = cloudS.getItemMeta();
		ItemMeta flameSMeta = flameS.getItemMeta();
		ItemMeta waterSMeta = waterS.getItemMeta();
		ItemMeta lavaSMeta = lavaS.getItemMeta();
		ItemMeta sparkSMeta = sparkS.getItemMeta();
		ItemMeta witchSMeta = witchS.getItemMeta();
		ItemMeta smokeSMeta = smokeS.getItemMeta();
		ItemMeta spellSMeta = spellS.getItemMeta();
		
		ItemMeta pageMeta = page.getItemMeta();
		
		ItemMeta pageReturnMeta = pagereturn.getItemMeta();
		

		ItemMeta stopMeta = stop.getItemMeta();
		


		snowSMeta.setDisplayName(HypixelEffect.config.hypixelInventorySnowSpiral.replace("&", "§"));
		cloudSMeta.setDisplayName(HypixelEffect.config.hypixelInventoryCloudSpiral.replace("&", "§"));
		flameSMeta.setDisplayName(HypixelEffect.config.hypixelInventoryFlameSpiral.replace("&", "§"));
		waterSMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWaterSpiral.replace("&", "§"));
		lavaSMeta.setDisplayName(HypixelEffect.config.hypixelInventoryLavaSpiral.replace("&", "§"));
		sparkSMeta.setDisplayName(HypixelEffect.config.hypixelInventorySparkSpiral.replace("&", "§"));
		witchSMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWitchSpiral.replace("&", "§"));
		smokeSMeta.setDisplayName(HypixelEffect.config.hypixelInventorySmokeSpiral.replace("&", "§"));
		spellSMeta.setDisplayName(HypixelEffect.config.hypixelInventorySpellSpiral.replace("&", "§"));
		//
		
		pageMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageRadar
				.replace("&", "§"));
		
		pageReturnMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageMain
				.replace("&", "§"));
		pageReturnMeta.addEnchant(Enchantment.DURABILITY, 1, true);

		
		if (Utils.Filtre.HasEffect(p)) {
			statut2 = HypixelEffect.config.hypixeleffectInvStatutOn.replace("&", "§");
		} else {
			statut2 = HypixelEffect.config.hypixeleffectInvStatutOff.replace("&", "§");
		}
		lore2.clear();
		lore2.add(HypixelEffect.config.hypixeleffectInvStatutPrefix.replace("&", "§") + " "
				+ statut2);
		stopMeta.setLore(lore2);
		stopMeta.setDisplayName(HypixelEffect.config.hypixelInventoryStop.replace("&", "§"));

		snowS.setItemMeta(snowSMeta);
		cloudS.setItemMeta(cloudSMeta);
		flameS.setItemMeta(flameSMeta);
		waterS.setItemMeta(waterSMeta);
		lavaS.setItemMeta(lavaSMeta);
		sparkS.setItemMeta(sparkSMeta);
		witchS.setItemMeta(witchSMeta);
		smokeS.setItemMeta(smokeSMeta);
		spellS.setItemMeta(spellSMeta);
		
		page.setItemMeta(pageMeta);
		
		pagereturn.setItemMeta(pageReturnMeta);

		stop.setItemMeta(stopMeta);

			
			inv2.setItem(0, snowS);
			inv2.setItem(1, spellS);
			inv2.setItem(2, flameS);
			inv2.setItem(3, waterS);
			inv2.setItem(4, lavaS);
			inv2.setItem(5, sparkS);
			inv2.setItem(6, witchS);
			inv2.setItem(7, smokeS);
			inv2.setItem(8, cloudS);
			
			inv2.setItem(35, page);
			
			inv2.setItem(28, pagereturn);
			
			inv2.setItem(27, stop);
			for (Player pInv : gui2.keySet()) {
			pInv.openInventory(inv2);
			gui2.remove(p);
			}
		
	} 
	}

}
