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
			case "Equals":
				x = 2;
				break;
			case "Not Equals":
				x = 3;
				break;
			case "More Than":
				x = 4;
				break;
			case "Less Than":
				x = 5;
				break;
			case "Equals Or More Than":
				x = 6;
				break;
			case "Equals Or Less Than":
				x = 7;
				break;
			case "Is Empty":
				x = 8;
				break;
			case "Is Not Empty":
				x = 9;
				break;

		}

		return x;
	}

}
