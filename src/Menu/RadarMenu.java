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

public class RadarMenu {
	
	final public static HashMap<Player, Inventory> gui3 = new HashMap<Player, Inventory>();
	static List<String> lore3 = new ArrayList<String>();
	private static String statut3 = "";
	
	public static void openRadarGUI(Player p) {
		
		if(!gui3.containsKey(p))  {
		
		Inventory inv3 = Bukkit.createInventory(null, (36),
				HypixelEffect.config.hypixeleffectInvRadarPrefix.replace("&", "§"));
		gui3.put(p, inv3);

		
		ItemStack snowR = new ItemStack(Material.SUGAR);
		ItemStack cloudR = new ItemStack(Material.QUARTZ);
		ItemStack flameR = new ItemStack(Material.BLAZE_POWDER);
		ItemStack waterR = new ItemStack(Material.WATER);
		ItemStack lavaR = new ItemStack(Material.LAVA);
		ItemStack sparkR = new ItemStack(Material.NETHER_STAR);
		ItemStack witchR = new ItemStack(Material.BOOK);
		ItemStack smokeR = new ItemStack(Material.INK_SACK);
		ItemStack spellR = new ItemStack(Material.SPIDER_EYE);
		
		ItemStack page = new ItemStack(Material.PAPER);
		ItemStack pagereturn = new ItemStack(Material.PAPER);
		
		ItemStack stop = new ItemStack(Material.REDSTONE_BLOCK);
		
		ItemMeta snowRMeta = snowR.getItemMeta();
		ItemMeta cloudRMeta = cloudR.getItemMeta();
		ItemMeta flameRMeta = flameR.getItemMeta();
		ItemMeta waterRMeta = waterR.getItemMeta();
		ItemMeta lavaRMeta = lavaR.getItemMeta();
		ItemMeta sparkRMeta = sparkR.getItemMeta();
		ItemMeta witchRMeta = witchR.getItemMeta();
		ItemMeta smokeRMeta = smokeR.getItemMeta();
		ItemMeta spellRMeta = spellR.getItemMeta();
		
		ItemMeta pageMeta = page.getItemMeta();
		ItemMeta pageReturnMeta = pagereturn.getItemMeta();
		
		ItemMeta stopMeta = stop.getItemMeta();
		
	
		snowRMeta.setDisplayName(HypixelEffect.config.hypixelInventorySnowRadar.replace("&", "§"));
		cloudRMeta.setDisplayName(HypixelEffect.config.hypixelInventoryCloudRadar.replace("&", "§"));
		flameRMeta.setDisplayName(HypixelEffect.config.hypixelInventoryFlameRadar.replace("&", "§"));
		waterRMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWaterRadar.replace("&", "§"));
		lavaRMeta.setDisplayName(HypixelEffect.config.hypixelInventoryLavaRadar.replace("&", "§"));
		sparkRMeta.setDisplayName(HypixelEffect.config.hypixelInventorySparkRadar.replace("&", "§"));
		witchRMeta.setDisplayName(HypixelEffect.config.hypixelInventoryWitchRadar.replace("&", "§"));
		smokeRMeta.setDisplayName(HypixelEffect.config.hypixelInventorySmokeRadar.replace("&", "§"));
		spellRMeta.setDisplayName(HypixelEffect.config.hypixelInventorySpellRadar.replace("&", "§"));
		
		pageMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageTornado
				.replace("&", "§"));
		
		pageReturnMeta.setDisplayName(HypixelEffect.config.hypixelInventoryPageSpiral
				.replace("&", "§"));
		
		pageReturnMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		
		if (Utils.Filtre.HasEffect(p)) {
			statut3 = HypixelEffect.config.hypixeleffectInvStatutOn.replace("&", "§");
		} else {
			statut3 = HypixelEffect.config.hypixeleffectInvStatutOff.replace("&", "§");
		}
		lore3.clear();
		lore3.add(HypixelEffect.config.hypixeleffectInvStatutPrefix + " "
				+ statut3);
		stopMeta.setLore(lore3);
		stopMeta.setDisplayName(HypixelEffect.config.hypixelInventoryStop.replace("&", "§"));

		
		snowR.setItemMeta(snowRMeta);
		cloudR.setItemMeta(cloudRMeta);
		flameR.setItemMeta(flameRMeta);
		waterR.setItemMeta(waterRMeta);
		lavaR.setItemMeta(lavaRMeta);
		sparkR.setItemMeta(sparkRMeta);
		witchR.setItemMeta(witchRMeta);
		smokeR.setItemMeta(smokeRMeta);
		spellR.setItemMeta(spellRMeta);
		
		page.setItemMeta(pageMeta);
		
		pagereturn.setItemMeta(pageReturnMeta);

		stop.setItemMeta(stopMeta);
			
			inv3.setItem(0, snowR);
			inv3.setItem(1, spellR);
			inv3.setItem(2, flameR);
			inv3.setItem(3, waterR);
			inv3.setItem(4, lavaR);
			inv3.setItem(5, sparkR);
			inv3.setItem(6, witchR);
			inv3.setItem(7, smokeR);
			inv3.setItem(8, cloudR);
			
			inv3.setItem(35, page);

			inv3.setItem(28, pagereturn);
			
			inv3.setItem(27, stop);
			for (Player pInv : gui3.keySet()) {
			pInv.openInventory(inv3);
			gui3.remove(p);
			}
	
	} 
	}

}
