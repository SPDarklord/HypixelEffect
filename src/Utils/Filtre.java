package Utils;

import org.bukkit.entity.Player;

public class Filtre {

	public static enum RotationType {

		ROTATION, SPIRAL, RADAR, TORNADO

	}

	public static boolean HasEffect(Player p) {

		if (!Maths.countdown_id.containsKey(p)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean HasPermission(Player p) {
		if (!p.hasPermission("hypixeleffect.use.*")
				|| !p.hasPermission("hypixeleffect.use.heart")
				|| !p.hasPermission("hypixeleffect.use.note")
				|| !p.hasPermission("hypixeleffect.use.flame")
				|| !p.hasPermission("hypixeleffect.use.water")
				|| !p.hasPermission("hypixeleffect.use.lava")
				|| !p.hasPermission("hypixeleffect.use.spark")
				|| !p.hasPermission("hypixeleffect.use.witch")
				|| !p.hasPermission("hypixeleffect.use.smoke")
				|| !p.hasPermission("hypixeleffect.use.cloud")
				|| !p.hasPermission("hypixeleffect.use.snowspiral")
				|| !p.hasPermission("hypixeleffect.use.snowradar")
				|| !p.hasPermission("hypixeleffect.use.snowtornado")
				|| !p.hasPermission("hypixeleffect.use.cloudspiral")
				|| !p.hasPermission("hypixeleffect.use.cloudradar")
				|| !p.hasPermission("hypixeleffect.use.cloudtornado")
				|| !p.hasPermission("hypixeleffect.use.flamespiral")
				|| !p.hasPermission("hypixeleffect.use.flameradar")
				|| !p.hasPermission("hypixeleffect.use.flametornado")
				|| !p.hasPermission("hypixeleffect.use.waterspiral")
				|| !p.hasPermission("hypixeleffect.use.waterradar")
				|| !p.hasPermission("hypixeleffect.use.watertornado")
				|| !p.hasPermission("hypixeleffect.use.lavaspiral")
				|| !p.hasPermission("hypixeleffect.use.lavaradar")
				|| !p.hasPermission("hypixeleffect.use.lavatornado")
				|| !p.hasPermission("hypixeleffect.use.sparkspiral")
				|| !p.hasPermission("hypixeleffect.use.sparkradar")
				|| !p.hasPermission("hypixeleffect.use.sparktornado")
				|| !p.hasPermission("hypixeleffect.use.witchspiral")
				|| !p.hasPermission("hypixeleffect.use.witchradar")
				|| !p.hasPermission("hypixeleffect.use.witchtornado")
				|| !p.hasPermission("hypixeleffect.use.smokespiral")
				|| !p.hasPermission("hypixeleffect.use.smokeradar")
				|| !p.hasPermission("hypixeleffect.use.smoketornado")
				|| !p.hasPermission("hypixeleffect.use.spellspiral")
				|| !p.hasPermission("hypixeleffect.use.spellradar")
				|| !p.hasPermission("hypixeleffect.use.spelltornado")) {
			return false;
		} else {
			return true;
		}
	}

	public static RotationType RotationType;

	public static void filtre(Player p, RotationType type, String particle,
			float radius, Boolean randomColor) {

		if (Utils.Maths.countdown_id.containsKey(p)) {
			Utils.Maths.stopRotation(p);
			switch (type) {
			case ROTATION:
				Utils.Maths.rotationEffect(p, particle, radius, randomColor);
				break;
			case SPIRAL:
				Utils.Maths.spiraleEffect(p, particle, randomColor);
				break;
			case RADAR:
				Utils.Maths.radarEffect(p, particle, randomColor);
				break;
			case TORNADO:
				Utils.Maths.tornadoEffect(p, particle, randomColor);
				break;
			}

		} else {

			switch (type) {
			case ROTATION:
				Utils.Maths.rotationEffect(p, particle, radius, randomColor);
				break;
			case SPIRAL:
				Utils.Maths.spiraleEffect(p, particle, randomColor);
				break;
			case RADAR:
				Utils.Maths.radarEffect(p, particle, randomColor);
				break;
			case TORNADO:
				Utils.Maths.tornadoEffect(p, particle, randomColor);
				break;
			}
		}
	}
}
