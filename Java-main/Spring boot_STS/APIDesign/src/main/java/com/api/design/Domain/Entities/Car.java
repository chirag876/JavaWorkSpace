package com.api.design.Domain.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.api.design.Application.Common.Interface.IHasDomainEvent;
import com.api.design.Domain.Common.DomainEvent;


@javax.persistence.Entity
public class Car implements IHasDomainEvent{

	  @javax.persistence.Id
	    private int id;

	    @NotBlank(message = "Name is required")
	    private String name;

	    @NotBlank(message = "Model is required")
	    private String model;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(@NotNull(message = "Name cannot be null") String name) {
	        this.name = name;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(@NotNull(message = "Model cannot be null") String model) {
	        this.model = model;
	    }

	    @Override
	    public List<DomainEvent> domainEvents() {
	        List<DomainEvent> domainEvent = new ArrayList<DomainEvent>();
	        return domainEvent;
	    }
	}
