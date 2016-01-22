package com.xebia.monopoly.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.xebia.monopoly.domain.spaces.*;
import com.xebia.monopoly.domain.spaces.TaxSpace;

/**
 * Representation of a monopoly board. We assume that in any game only one board
 * is used, and that any thread only deals with a single game.
 */
@SuppressWarnings("serial")
public class Board implements Serializable {

	public final Start START = new Start();
	public final Jail JAIL = new Jail();

	private final List<Space> spaces = new ArrayList<Space>();
	private Stack<Card> communityChest = new Stack<Card>();
	private Stack<Card> chance = new Stack<Card>();

	public Board() {
		add(START);
		add(new Realty("Mediterranean Avenue", 60, 2));
		add(new DrawCard("Community Chest", communityChest));
		add(new Realty("Baltic Avenue", 60, 4));
		add(new TaxSpace("Income Tax", 200));
		add(new Station("Reading Railroad"));
		add(new Realty("Oriental Avenue", 100, 6));
		add(new DrawCard("Chance", chance));
		add(new Realty("Vermont Avenue", 100, 6));
		add(new Realty("Conneticut Avenue", 120, 8));
		add(JAIL); // Duo-step Just visiting
		add(new Realty("St. Charles Place", 140, 10));
		add(new Utility("Electric Company"));
		add(new Realty("States Avenue", 140, 10));
		add(new Realty("Virginia Avenue", 160, 12));
		add(new Station("Pennsylvania Railroad"));
		add(new Realty("St. James Place", 180, 14));
		add(new DrawCard("Community Chest", communityChest));
		add(new Realty("Tennessee Avenue", 180, 14));
		add(new Realty("New York Avenue", 200, 16));
		add(new FreeParking());
		add(new Realty("Kentucky Avenue", 220, 18));
		add(new DrawCard("Chance", chance));
		add(new Realty("Indiana Avenue", 220, 18));
		add(new Realty("Illinois Avenue", 240, 20));
		add(new Station("B&O Railroad"));
		add(new Realty("Atlantic Avenue", 260, 22));
		add(new Realty("Ventnor Avenue", 260, 22));
		add(new Utility("Water Works"));
		add(new Realty("Marvin Gardens", 280, 22));
		add(new PoliceAgent(JAIL));
		add(new Realty("Pacific Avenue", 300, 26));
		add(new Realty("North Carolina Avenue", 300, 26));
		add(new DrawCard("Community Chest", communityChest));
		add(new Realty("Pennsylvania Avenue", 320, 28));
		add(new Station("Short Line"));
		add(new DrawCard("Chance", chance));
		add(new Realty("Park Place", 350, 35));
		add(new TaxSpace("Luxury Tax", 100));
		add(new Realty("Boardwalk", 400, 50));
	}

	public Space findLocation(String locationName) {
		for(Space space : spaces) {
			if (space.getName().equals(locationName)) {
				return space;
			}
		}
		return null;
	}

	private void add(AbstractSpace space) {
        space.setPosition(spaces.size());
		spaces.add(space);
	}

	public void move(Player player, int roll) {
		Space newSpace = spaces.get(calculateNewPosition(player, roll));
		player.setCurrentPosition(newSpace);
		if (newSpace instanceof Actionable) {
		   ((Actionable) newSpace).execute(player);
		}
	}

	private int calculateNewPosition(Player player, int roll) {
		int oldPosition = spaces.indexOf(player.getCurrentPosition());
		int sum = oldPosition + roll;
		if (sum >= spaces.size()) {
			player.receiveMoney(200);
			return sum - spaces.size();
		} else {
			return sum;
		}
	}

	public List<Space> getSpaces() {
		return new ArrayList<Space>(spaces);
	}
}
