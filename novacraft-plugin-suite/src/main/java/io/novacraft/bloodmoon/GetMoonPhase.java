package io.novacraft.bloodmoon;

import org.bukkit.World;

public class GetMoonPhase {
	public static MoonPhase getMoonPhase(World w) {
		int days = (int) (w.getFullTime() / 24000);
		int phase = days % 8;
		
		System.out.println("Full time: " + w.getFullTime());
		
		System.out.println("Days: "+ days + "\nPhase: "+ phase);
		
		switch(phase) {
			case 0:
				return MoonPhase.FULL_MOON;
			case 1:
				return MoonPhase.WANING_GIBBOUS;
			case 2:
				return MoonPhase.LAST_QUARTER;
			case 3:
				return MoonPhase.WANING_CRESCENT;
			case 4:
				return MoonPhase.NEW_MOON;
			case 5:
				return MoonPhase.WAXING_CRESCENT;
			case 6: 
				return MoonPhase.FIRST_QUARTER;
			case 7:
				return MoonPhase.WAXING_GIBBOUS;
		}
		
		return null;
	}
}
