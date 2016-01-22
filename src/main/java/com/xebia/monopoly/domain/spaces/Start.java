package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Actionable;
import com.xebia.monopoly.domain.Player;

/**
 *
 */
@SuppressWarnings("serial")
public class Start extends AbstractSpace implements Actionable {

	public Start() {
		super("GO");
	}

	/**
	 * Player receives salary
	 * @param player
	 */
	public void execute(Player player) {
	}

}
