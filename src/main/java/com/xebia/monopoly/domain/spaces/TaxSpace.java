package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Actionable;
import com.xebia.monopoly.domain.Bank;
import com.xebia.monopoly.domain.Player;

/**
 *
 */
@SuppressWarnings("serial")
public class TaxSpace extends AbstractSpace implements Actionable {
	private long tax;

	public TaxSpace(String name, long tax) {
		super(name);
		this.tax = tax;
	}

	/**
	 * Pay tax to the bank.
	 * @param player The player that has to pay.
	 */
	public void execute(Player player) {
		player.pay(tax, Bank.BANK);
	}
}
