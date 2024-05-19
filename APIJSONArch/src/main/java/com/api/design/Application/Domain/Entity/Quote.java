package com.api.design.Application.Domain.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Quote")
public class Quote {

	@javax.persistence.Id
    @Column(name = "ID")
    private UUID Id;
	private int qId;
	
}
