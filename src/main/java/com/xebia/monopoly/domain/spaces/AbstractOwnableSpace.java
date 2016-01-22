package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Actionable;
import com.xebia.monopoly.domain.Ownable;
import com.xebia.monopoly.domain.Player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractOwnableSpace extends AbstractSpace implements Ownable, Actionable {
	private static final Logger LOGGER = LoggerFactory.getLogger(Realty.class);
	protected long cost;
	protected Player owner;

	public AbstractOwnableSpace(String name, long cost) {
		super(name);
		this.cost = cost;
	}

	public long getCost() {
		return cost;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * Pay the rent to the owner of this space.
	 * @param player
	 */
	public void execute(Player player) {
		if (owner != null && !owner.equals(player)) {
			long rent = getRent();
			player.pay(rent, owner);
			LOGGER.info("Player {} paid {} rent to {}", new Object[] {player, rent, owner});
		}
	}

	public boolean isUnowned() {
		return !isOwned();
	}

	public boolean isOwned() {
		return owner != null;
	}

	// Not an official getter, otherwise Json will run into a recursive loop.
	public Player owner() {
		return owner;
	}
}
