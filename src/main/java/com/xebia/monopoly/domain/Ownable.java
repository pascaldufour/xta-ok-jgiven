/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xebia.monopoly.domain;

/**
 * A Square that implements Ownable can be bought.
 */
public interface Ownable {

	long getCost();

	long getRent();

	boolean isUnowned();

	void setOwner(Player player);
	
	boolean isOwned();
	
	Player owner();
}
