package Utils;

import java.io.File;
import java.util.Arrays;



public class Configuration extends Skyoconfig {

	@ConfigOptions(name = "hypixeleffect.prefix")
	public String hypixeleffectPrefix = "&7[&3HypixelEffect&7]";
	@ConfigOptions(name = "hypixeleffect.invprefix")
	public String hypixeleffectInvPrefix = "&7[&3HypixelEffect&7]";
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
	@ConfigOptions(name = "hypixelinventory.snow")
	public String hypixelInventorySnow = "&bSnow Effect";
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
	@ConfigOptions(name = "hypixeleffect.message.snow")
	public String hypixeleffectSnow = "&bSnow";
	@ConfigOptions(name = "hypixeleffect.message.stop")
	public String hypixeleffectStop = "&4Effect disabled !";
	@ConfigOptions(name = "hypixeleffect.message.alreadystop")
	public String hypixeleffectAlreadyStop = "&4Effect already disabled !";
	@ConfigOptions(name = "hypixeleffect.message.permission")
	public String hypixeleffectPermission = "&cYou don't have permission!";

	
	@ConfigOptions(name = "hypixelconfig.disableItemWithoutPermissions")
	public boolean disableItem = true;
	@ConfigOptions(name = "hypixelconfig.itemOnJoin")
	public boolean itemOnJoin = true;
	@ConfigOptions(name = "hypixelconfig.specialsound")
	public boolean specialSounds = true;
//	@ConfigOptions(name = "hypixelconfig.mode")
//	public boolean HypixelMode = false;
	
	@ConfigOptions(name = "hypixelinventory.position.heart")
	public int positionHeart = 0;
	@ConfigOptions(name = "hypixelinventory.position.music")
	public int positionMusic = 1;
	@ConfigOptions(name = "hypixelinventory.position.flame")
	public int positionFlame = 2;
	@ConfigOptions(name = "hypixelinventory.position.water")
	public int positionWater = 3;
	@ConfigOptions(name = "hypixelinventory.position.lava")
	public int positionLava = 4;
	@ConfigOptions(name = "hypixelinventory.position.spark")
	public int positionSpark = 5;
	@ConfigOptions(name = "hypixelinventory.position.witch")
	public int positionWitch = 6;
	@ConfigOptions(name = "hypixelinventory.position.snow")
	public int positionSnow = 7;
	@ConfigOptions(name = "hypixelinventory.position.stop")
	public int positionStop = 8;
	
	
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
