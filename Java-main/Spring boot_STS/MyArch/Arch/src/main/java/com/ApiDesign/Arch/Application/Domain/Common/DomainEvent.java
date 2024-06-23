package com.ApiDesign.Arch.Application.Domain.Common;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class  DomainEvent {
	
	public  OffsetDateTime _DateOccured= OffsetDateTime.now();
	private Boolean IsPublished;

	 public DomainEvent() {
		
		this._DateOccured = _DateOccured;
	}

	public OffsetDateTime getDateOccured() {
		return this._DateOccured;
	}

	public void setDateOccured(OffsetDateTime dateOccured) {
		this._DateOccured  = dateOccured;
	}

	public Boolean getIsPublished() {
		return this.IsPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.IsPublished = isPublished;
	}
	
	
	
}
