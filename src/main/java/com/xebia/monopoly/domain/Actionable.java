/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.xebia.monopoly.domain;

/**
 * Any space that implements this interface can react onto a player landing there.
 */
public interface Actionable {

	public void execute(Player player);
}
