package com.xebia.monopoly.domain.spaces;


/**
 * Station, Street or Utility company.
 */
@SuppressWarnings("serial")
public class Realty extends AbstractOwnableSpace {

	private int rent;

	public Realty(String name, int cost, int rent) {
		super(name, cost);
		this.rent = rent;
	}

	public long getRent() {
		return rent;
	}
}
