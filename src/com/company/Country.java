package com.company;

public enum Country {
	USSR(true),
	GERMANY(false),
	UK(true),
	JAPAN(true),
	USA(true);


	Country(boolean isAllies) {
		this.isAllies = isAllies;
	}

	public boolean isAllies() {
		return isAllies;
	}

	private boolean isAllies;
}
