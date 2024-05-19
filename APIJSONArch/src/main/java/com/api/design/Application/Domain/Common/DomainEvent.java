package com.api.design.Application.Domain.Common;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class  DomainEvent {
	
	private  OffsetDateTime DateOccured;
	private Boolean IsPublished;

	protected DomainEvent() {
		
		DateOccured = OffsetDateTime.now(ZoneOffset.UTC);
	}

	public OffsetDateTime getDateOccured() {
		return DateOccured;
	}

	public void setDateOccured(OffsetDateTime dateOccured) {
		DateOccured = dateOccured;
	}

	public Boolean getIsPublished() {
		return IsPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		IsPublished = isPublished;
	}
	
	
	
}
