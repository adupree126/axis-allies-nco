package com.company;

public enum Unit {

	INFANTRY(1, 2, 3, 1, UnitType.LAND),
	ARTILLERY(2, 2, 4, 1, UnitType.LAND),
	TANK(3,3, 6, 2, UnitType.LAND),
	ANTIAIRCRAFT_ARTILLERY(0,0,5,1,UnitType.LAND),
	INDUSTRIAL_COMPLEX(0,0,15,0, UnitType.LAND),
	FIGHTER(3,4,10,4,UnitType.AIR),
	BOMBER(4,1,12,6,UnitType.AIR),
	BATTLESHIP(4,4,20,2,UnitType.SEA),
	AIRCRAFT_CARRIER(1,2,14,2,UnitType.SEA),
	CRUISER(3,3,12,2,UnitType.SEA),
	DESTROYER(2,2,8,2,UnitType.SEA),
	SUBMARINE(2,1,6,2,UnitType.SEA),
	TRANSPORT(0,0,7,2,UnitType.SEA);


	Unit(int attack, int defense, int cost, int move, UnitType type) {
		this.attack = attack;
		this.defense = defense;
		this.cost = cost;
		this.move = move;
		this.type = type;
	}

	public final int attack;
	public final int defense;
	public final int cost;
	public final int move;
	public final UnitType type;



	@Override
	public String toString() {
		String clean_string = name()
				.replace("_", " ")
				.toLowerCase();

		return clean_string;
	}       // AIRCRAFT_CARRIER -> aircraft carrier

	enum UnitType{
		LAND, AIR, SEA;
	}

}
