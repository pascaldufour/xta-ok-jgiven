package com.xebia.monopoly.domain;

import java.io.Serializable;

public interface Space extends Serializable {

    String getName();

	// Position for Ajax-item placement
	int getPosition();
}
