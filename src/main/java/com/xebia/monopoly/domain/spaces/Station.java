package com.xebia.monopoly.domain.spaces;


/**
 *
 */
@SuppressWarnings("serial")
public class Station extends AbstractOwnableSpace {

	public Station(String name) {
		super(name, 200);
	}

	public long getRent() {
		return 25;
	}
}
