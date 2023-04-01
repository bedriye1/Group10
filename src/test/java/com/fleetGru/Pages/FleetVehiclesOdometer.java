package com.fleetGru.Pages;

import java.lang.invoke.SwitchPoint;

public class FleetVehiclesOdometer {

	public int stringToInt (String text){
		int x = 0;
		switch (text){
			case "Between":
				x = 0;
				break;
			case "Not Between":
				x = 1;
				break;
			case "Less Than":
				x = 5;
				break;
		}

		return x;
	}

}
