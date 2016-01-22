package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Dice;
import com.xebia.monopoly.domain.Ownable;

/**
 *
 */
@SuppressWarnings("serial")
public class Utility extends AbstractOwnableSpace {

	public Utility(String name) {
		super(name, 150);
	}

	public long getRent() {
		int utilities = 0;
		if (!isUnowned()) {
			for (Ownable ownable : owner.getPossessions()) {
				if (ownable instanceof Utility) {
					utilities++;
				}
			}
		}
		return utilities > 1 ? Dice.getInstance().view() * 2 : Dice.getInstance().view() * 6;
	}


}
