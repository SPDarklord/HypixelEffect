package Utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import Particles.ParticleEffects;

import com.coco_gigpn.fr.HypixelEffect;

public class Maths extends HypixelEffect{

	final public static HashMap<Player, Integer> countdown_id = new HashMap<Player, Integer>();
//	final public static HashMap<Player, Integer> id = new HashMap<Player, Integer>();

	
	public static void rotationEffect(final Player p,final String particle, final float radius ,final Boolean randomColor) {
		
		if (! countdown_id.containsKey(p)) {
		
			final double radialsPerStep = Math.PI / HypixelEffect.config.angleparticule;
//			if (!HypixelEffect.config.HypixelMode)  {
		int i = Bukkit.getScheduler().runTaskTimer(HypixelEffect.plugin, new Runnable() {
			float step = 0;
			public void run() {
				
				Location loc = p.getLocation();
				loc.add(0, HypixelEffect.config.height, 0);
				loc.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);
				if (randomColor) {
					ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 1.0F, 1);
				} else {
				ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 0.0F, 1);
				}
				step++;
			
			}
		}, HypixelEffect.config.refreshtime, HypixelEffect.config.refreshtime).getTaskId();
		countdown_id.put(p, i);
//		}
//			else {
//			int i = Bukkit.getScheduler().runTaskTimer(HypixelEffect.plugin, new Runnable() {
//
//				public void run() {
//				
//					Location loc = p.getLocation().add(0.0f , 1.9f , 0.0f);
//					if (id.containsKey(p)) {
//						Bukkit.getServer().getScheduler().cancelTask(id.get(p));
//						id.remove(p);
//					}
//					functionRotation(p , loc, particle, radius, randomColor);
//				
//				}
//			}, 10L, 10L).getTaskId();
//			countdown_id.put(p, i);
//		}
		} else {
			stopRotation(p);
		}
		
	}
	
	//Not Working :(
	
//	public static void functionRotation(Player p, final Location loc, final String particle, final float radius, final Boolean randomColor) {
//		final double radialsPerStep = Math.PI / 6;
//		int i2 = Bukkit.getScheduler().runTaskTimer(HypixelEffect.plugin, new Runnable() {
//			float step = 0;
//			public void run() {
//			
//				loc.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);
//
//				if (randomColor) {
//					ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 1.0F, 1);
//				} else {
//				ParticleEffects.valueOf(particle).display(loc, 0.0F, 0.0F, 0.0F, 0.0F, 1);
//				}
//				step++;
//			
//			}
//		}, 1L, 1L).getTaskId();
//		id.put(p, i2);
//		
//	}
	
	public static void stopRotation(Player p) {
		if (countdown_id.containsKey(p)) {
		Bukkit.getServer().getScheduler().cancelTask(countdown_id.get(p));
		countdown_id.remove(p);
//		if (id.containsKey(p)) {
//			Bukkit.getServer().getScheduler().cancelTask(id.get(p));
//			id.remove(p);
//		}
		} else {
			if (HypixelEffect.config.specialSounds) 
				p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);
			else p.sendMessage(HypixelEffect.config.hypixeleffectAlreadyStop.replace("&", "§"));
			
		}
	}
}
