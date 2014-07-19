package Utils;

import org.bukkit.entity.Player;


public class Filtre {

	public static void filtre(Player p,String particle, float radius, Boolean randomColor) {
		
		if(Utils.Maths.countdown_id.containsKey(p)) {
			Utils.Maths.stopRotation(p);
			Utils.Maths.rotationEffect(p, particle, radius, randomColor);
		} else {
			Utils.Maths.rotationEffect(p, particle, radius, randomColor);
		}
	}
}
