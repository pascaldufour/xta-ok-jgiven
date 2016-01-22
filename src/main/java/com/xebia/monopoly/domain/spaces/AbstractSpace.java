package com.xebia.monopoly.domain.spaces;

import com.xebia.monopoly.domain.Space;

/**
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractSpace implements Space {
	protected String name;
	private int position;

	public AbstractSpace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof AbstractSpace)) {
			return false;
		}
		AbstractSpace sq = (AbstractSpace) obj;
		return (sq.getName() != null && sq.getName().equals(getName()));
	}


}
