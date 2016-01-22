package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Actionable;
import com.xebia.monopoly.domain.Player;

/**
 *
 */
@SuppressWarnings("serial")
public class PoliceAgent extends AbstractSpace implements Actionable {

	public PoliceAgent(Jail jail) {
		super("Police Agent / Go To Jail");
	}

	public void execute(Player player) {
		player.gotSentToJail();
	}
}
