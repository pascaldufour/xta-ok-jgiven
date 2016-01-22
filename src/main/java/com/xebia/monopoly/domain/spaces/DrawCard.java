package com.xebia.monopoly.domain.spaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.xebia.monopoly.domain.Actionable;
import com.xebia.monopoly.domain.Card;
import com.xebia.monopoly.domain.Player;

/**
 *
 */
@SuppressWarnings("serial")
public class DrawCard extends AbstractSpace implements Actionable {

	private Stack<Card> stack;
	private List<Card> drawn = new ArrayList<Card>();
	private double unifier = Math.random() * 1000;

	public DrawCard(String name, Stack<Card> stack) {
		super(name);
		this.stack = stack;
	}

	public void execute(Player player) {
		//throw new UnsupportedOperationException("Don't know how to draw card");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof DrawCard)) {
			return false;
		}
		DrawCard card = (DrawCard) obj;
		return (card.getName() != null && card.getName().equals(getName()) && unifier == card.getUnifier());
	}

	public double getUnifier() {
		return unifier;
	}

}
