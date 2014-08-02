package Utils;

import java.io.File;
import java.util.Arrays;



public class Configuration extends Skyoconfig {

	@ConfigOptions(name = "hypixeleffect.prefix")
	public String hypixeleffectPrefix = "&7[&3HypixelEffect&7]";
	@ConfigOptions(name = "hypixeleffect.inv.mainprefix")
	public String hypixeleffectInvMainPrefix = "&7[&3HypixelEffect&7]";
	@ConfigOptions(name = "hypixeleffect.inv.spiralprefix")
	public String hypixeleffectInvSpiralPrefix = "&7[&3HypixelEffect&7] &4Spiral";
	@ConfigOptions(name = "hypixeleffect.inv.radarprefix")
	public String hypixeleffectInvRadarPrefix = "&7[&3HypixelEffect&7] &4Radar";
	@ConfigOptions(name = "hypixeleffect.inv.tornadoprefix")
	public String hypixeleffectInvTornadoPrefix = "&7[&3HypixelEffect&7] &4Tornado";
	@ConfigOptions(name = "hypixeleffect.inv.statutprefix")
	public String hypixeleffectInvStatutPrefix = "&7Effect statut:";
	@ConfigOptions(name = "hypixeleffect.inv.statuton")
	public String hypixeleffectInvStatutOn = "&8[&c&lOff&8]";
	@ConfigOptions(name = "hypixeleffect.inv.statutoff")
	public String hypixeleffectInvStatutOff = "&8[&2&lOn&8]";
	@ConfigOptions(name = "hypixeleffect.inv.info")
	public String hypixeleffectInvInfo = "&8Players using:";
	
	@ConfigOptions(name = "hypixelinventory.heart")
	public String hypixelInventoryHeart = "&4Heart Effect";
	@ConfigOptions(name = "hypixelinventory.music")
	public String hypixelInventoryMusic = "&2Music Effect";
	@ConfigOptions(name = "hypixelinventory.flame")
	public String hypixelInventoryFlame = "&6Flame Effect";
	@ConfigOptions(name = "hypixelinventory.water")
	public String hypixelInventoryWater = "&3Water Effect";
	@ConfigOptions(name = "hypixelinventory.lava")
	public String hypixelInventoryLava = "&cLava Effect";
	@ConfigOptions(name = "hypixelinventory.spark")
	public String hypixelInventorySpark = "&fSpark Effect";
	@ConfigOptions(name = "hypixelinventory.witch")
	public String hypixelInventoryWitch = "&5Witch Effect";
	@ConfigOptions(name = "hypixelinventory.smoke")
	public String hypixelInventorySmoke = "&7Smoke Effect";
	@ConfigOptions(name = "hypixelinventory.cloud")
	public String hypixelInventoryCloud = "&fCloud Effect";
	

	@ConfigOptions(name = "hypixelinventory.snowSpiral")
	public String hypixelInventorySnowSpiral = "&bSnow spiral Effect";
	@ConfigOptions(name = "hypixelinventory.cloudSpiral")
	public String hypixelInventoryCloudSpiral  = "&fCloud spiral Effect";
	@ConfigOptions(name = "hypixelinventory.flameSpiral")
	public String hypixelInventoryFlameSpiral  = "&6Flame spiral Effect";
	@ConfigOptions(name = "hypixelinventory.waterSpiral")
	public String hypixelInventoryWaterSpiral  = "&3Water spiral Effect";
	@ConfigOptions(name = "hypixelinventory.lavaSpiral")
	public String hypixelInventoryLavaSpiral  = "&cLava spiral Effect";
	@ConfigOptions(name = "hypixelinventory.sparkSpiral")
	public String hypixelInventorySparkSpiral  = "&fSpark spiral Effect";
	@ConfigOptions(name = "hypixelinventory.witchSpiral")
	public String hypixelInventoryWitchSpiral  = "&5Witch spiral Effect";
	@ConfigOptions(name = "hypixelinventory.smokeSpiral")
	public String hypixelInventorySmokeSpiral  = "&7Smoke spiral Effect";
	@ConfigOptions(name = "hypixelinventory.spellSpiral")
	public String hypixelInventorySpellSpiral = "&dSpell spiral Effect";
	
	@ConfigOptions(name = "hypixelinventory.snowRadar")
	public String hypixelInventorySnowRadar = "&bSnow radar Effect";
	@ConfigOptions(name = "hypixelinventory.cloudRadar")
	public String hypixelInventoryCloudRadar  = "&fCloud radar Effect";
	@ConfigOptions(name = "hypixelinventory.flameRadar")
	public String hypixelInventoryFlameRadar  = "&6Flame radar Effect";
	@ConfigOptions(name = "hypixelinventory.waterRadar")
	public String hypixelInventoryWaterRadar  = "&3Water radar Effect";
	@ConfigOptions(name = "hypixelinventory.lavaRadar")
	public String hypixelInventoryLavaRadar  = "&cLava radar Effect";
	@ConfigOptions(name = "hypixelinventory.sparkRadar")
	public String hypixelInventorySparkRadar  = "&fSpark radar Effect";
	@ConfigOptions(name = "hypixelinventory.witchRadar")
	public String hypixelInventoryWitchRadar  = "&5Witch radar Effect";
	@ConfigOptions(name = "hypixelinventory.smokeRadar")
	public String hypixelInventorySmokeRadar  = "&7Smoke radar Effect";
	@ConfigOptions(name = "hypixelinventory.spellRadar")
	public String hypixelInventorySpellRadar = "&dSpell radar Effect";
	
	@ConfigOptions(name = "hypixelinventory.snowTornado")
	public String hypixelInventorySnowTornado = "&bSnow tornado Effect";
	@ConfigOptions(name = "hypixelinventory.cloudTornado")
	public String hypixelInventoryCloudTornado  = "&fCloud tornado Effect";
	@ConfigOptions(name = "hypixelinventory.flameTornado")
	public String hypixelInventoryFlameTornado  = "&6Flame tornado Effect";
	@ConfigOptions(name = "hypixelinventory.waterTornado")
	public String hypixelInventoryWaterTornado  = "&3Water tornado Effect";
	@ConfigOptions(name = "hypixelinventory.lavaTornado")
	public String hypixelInventoryLavaTornado  = "&cLava tornado Effect";
	@ConfigOptions(name = "hypixelinventory.sparkTornado")
	public String hypixelInventorySparkTornado  = "&fSpark tornado Effect";
	@ConfigOptions(name = "hypixelinventory.witchTornado")
	public String hypixelInventoryWitchTornado  = "&5Witch tornado Effect";
	@ConfigOptions(name = "hypixelinventory.smokeTornado")
	public String hypixelInventorySmokeTornado = "&7Smoke tornado Effect";
	@ConfigOptions(name = "hypixelinventory.spellTornado")
	public String hypixelInventorySpellTornado = "&dSpell tornado Effect";
	
	@ConfigOptions(name = "hypixelinventory.pagemain")
	public String hypixelInventoryPageMain = "&4To rotation effects";
	@ConfigOptions(name = "hypixelinventory.pageradar")
	public String hypixelInventoryPageRadar = "&4To radar effects";
	@ConfigOptions(name = "hypixelinventory.pagespiral")
	public String hypixelInventoryPageSpiral = "&4to spiral effects";
	@ConfigOptions(name = "hypixelinventory.pagetornado")
	public String hypixelInventoryPageTornado = "&4To tornado effects";
	
	@ConfigOptions(name = "hypixelinventory.stop")
	public String hypixelInventoryStop = "&4Stop your effect";
	
	@ConfigOptions(name = "hypixeleffect.message.activate")
	public String hypixeleffectActivate= "&aYou activated: ";
	@ConfigOptions(name = "hypixeleffect.message.reload")
	public String hypixeleffectReload= "&aConfiguration reloaded !";
	@ConfigOptions(name = "hypixeleffect.message.heart")
	public String hypixeleffectHeart = "&4Heart";
	@ConfigOptions(name = "hypixeleffect.message.music")
	public String hypixeleffectMusic = "&2Music";
	@ConfigOptions(name = "hypixeleffect.message.flame")
	public String hypixeleffectFlame = "&6Flame";
	@ConfigOptions(name = "hypixeleffect.message.water")
	public String hypixeleffectWater = "&4Water";
	@ConfigOptions(name = "hypixeleffect.message.lava")
	public String hypixeleffectLava = "&cLava";
	@ConfigOptions(name = "hypixeleffect.message.spark")
	public String hypixeleffectSpark = "&fSpark";
	@ConfigOptions(name = "hypixeleffect.message.witch")
	public String hypixeleffectWitch= "&5Witch";
	@ConfigOptions(name = "hypixeleffect.message.smoke")
	public String hypixeleffectSmoke= "&7Smoke";
	@ConfigOptions(name = "hypixeleffect.message.snow")
	public String hypixeleffectSnow = "&bSnow";
	@ConfigOptions(name = "hypixeleffect.message.cloud")
	public String hypixeleffectCloud = "&fCloud";
	@ConfigOptions(name = "hypixeleffect.message.spell")
	public String hypixeleffectSpell = "&dSpell";
	@ConfigOptions(name = "hypixeleffect.message.stop")
	public String hypixeleffectStop = "&4Effect disabled!";
	@ConfigOptions(name = "hypixeleffect.message.alreadystop")
	public String hypixeleffectAlreadyStop = "&4Effect already disabled !";
	@ConfigOptions(name = "hypixeleffect.message.permission")
	public String hypixeleffectPermission = "&cYou don't have permission!";

	
	@ConfigOptions(name = "hypixelconfig.itemOnJoin")
	public boolean itemOnJoin = true;
	@ConfigOptions(name = "hypixelconfig.specialsound")
	public boolean specialSounds = true;
	@ConfigOptions(name = "hypixelconfig.info")
	public boolean playersUsing = true;
//	@ConfigOptions(name = "hypixelconfig.mode")
//	public boolean HypixelMode = false;
	
	
	
	@ConfigOptions(name = "hypixelconfig.radius")
	public float radius = 0.4f; 
	@ConfigOptions(name = "hypixelconfig.height")
	public float height = 2f; 
	@ConfigOptions(name = "hypixelconfig.refreshtime")
	public int refreshtime = 2; 
	@ConfigOptions(name = "hypixelconfig.angle")
	public int angleparticule = 4; 
	

	public Configuration(final File file) {
		super(file, Arrays.asList("HypixelEffect Configuration"));
	}
}
