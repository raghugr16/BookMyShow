package org.rags.bookmyshow.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Root {
	
	private Date recordTime;
	private boolean isActive;

	public Root() {
	}

	public Root(Date recordTime, boolean isActive) {
		this.recordTime = recordTime;
		this.isActive = isActive;
	}
}
