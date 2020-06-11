package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/*
An army represents one country's forces in one region
 */
public class Army {

	public final Country country;
	private ArrayList<Unit> units;      // maps each unit type to quantity of that unit



	public Army(Country country, ArrayList<Unit> units) {
		this.country = country;
		this.units = units;
	}

	public Army(Country country) {
		this(country, new ArrayList<Unit>());
	}

	public boolean LoseUnit(){
		units.remove(0);          // remove the lowest priority unit
		return units.size() <= 0;       // return true if forces are exhausted
	}   // remove lowest priority unit then return true if units is empty

	// todo: add support for submarine vs. air

	// sort units according to input, with low priority units at the front.
	public boolean setPriority(Priority priority){
		switch (priority){
			case ECONOMY:
				units.sort((Unit u1, Unit u2) -> u1.cost - u2.cost);        // sort by cost ascending
				return true;

			case HIGH_ATTACK_ROLLS:
				units.sort((Unit u1, Unit u2) -> u1.attack - u2.attack);        // sort by attack ascending
				return true;

			case HIGH_DEFENSE_ROLLS:
				units.sort((Unit u1, Unit u2) -> u1.defense - u2.defense);        // sort by attack ascending
				return true;


			case INVASION :
				units.sort((Unit u1, Unit u2) -> u1.attack - u2.attack);        // sort by attack ascending

				//  iterate over units to find the highest attacking land unit
				Unit highestLandUnit = null;

				for (Unit unit : units) {
					if (unit.type == Unit.UnitType.LAND && (highestLandUnit == null || unit.attack > highestLandUnit.attack)){
						highestLandUnit = unit;
					}
				}

				// add highest land unit to end of units
				if (highestLandUnit != null){
					units.remove(highestLandUnit);
					units.add(highestLandUnit);
				}
				return true;


			default:
				return false;
		}
	}   // returns true for valid inputs, false otherwise




	enum Priority{
		ECONOMY,        // lose low cost first
		HIGH_ATTACK_ROLLS,     // lose low rolling units first
		HIGH_DEFENSE_ROLLS,     // lose low rolling units first
		INVASION;        // lose low rolling units first, leaving one high-rolling land unit at the end
	}
}
