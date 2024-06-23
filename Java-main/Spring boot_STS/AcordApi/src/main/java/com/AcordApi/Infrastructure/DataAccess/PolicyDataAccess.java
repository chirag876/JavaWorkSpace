package com.AcordApi.Infrastructure.DataAccess;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.AcordApi.Application.Common.DAO.PolicyDAO;
import com.AcordApi.Application.Common.Interface.IDomainEventService;
import com.AcordApi.Application.Common.Interface.IPolicyDataAccess;
import com.AcordApi.Application.Domain.Entity.Policy;
import com.AcordApi.Infrastructure.DataAccess.PolicyDataAccess.policyNotFoundException;

@Service
public class PolicyDataAccess implements IPolicyDataAccess{
	
	
	@Autowired
	private PolicyDAO policyDao;
	// create a logger object to log events and errors
	Logger _logger = LoggerFactory.getLogger(PolicyDAO.class);
	
	@Autowired
	private IDomainEventService domainEventService;

	// Add a new RetrievePolicy entity to the database
	@Override
	public Policy AddPolicy(Policy policy) {
		try {
			_logger.trace("PolicyDataAccess.AddPolicy - In process");

			// save the RetrievePolicy entity using the DAO object
			policyDao.save(policy);

		} catch (Exception ex) {
			_logger.error("PolicyDataAccess.AddPolicy" + ex.getMessage());

		}

		// dispatch events related to the entity
		DispatchEvents(policy);

		// return the saved entity
		return policy;
	}

	// Get a list of all RetrievePolicy entities from the database
	@Override
	public List<Policy> GetList() {
		try {
			_logger.trace("PolicyDataAccess.GetAll - In process");
			return policyDao.findAll();
		}
		catch(Exception ex) {
			_logger.error("PolicyDataAccess.GetAll" + ex.getMessage());
		}
		
		return null;
	}

	// Get a RetrievePolicy entity by its unique id
	public Policy GetById(UUID id) {
		return policyDao.getById(id);
	}

	// Update an existing RetrievePolicy entity in the database
	@Override
	public Policy Update(Policy policy) {
		
		try {
			_logger.info("PolicyDataAccess.Update - id" + policy.getId() );
		 policyDao.save(policy);
		}
		catch(Exception ex) {
			_logger.info("PolicyDataAccess.Update - id" + policy.getId() + ex.getMessage() );
			
		}
		return null;
	}

	// Delete a RetrievePolicy entity from the database by its unique id
	public UUID delete(UUID id) {
		try {
			_logger.info("PolicyDataAccess.delete- id" + id );
			policyDao.deleteById(id);
			return null;
		} catch (EmptyResultDataAccessException e) {
			// throw a custom exception if the entity is not found
			_logger.info("PolicyDataAccess.delete - Could not find policy with id" + id );
			throw new policyNotFoundException("Could not find policy with id " + id);
		}
	}

	// define a custom exception to be thrown when a RetrievePolicy entity is not found
	public class policyNotFoundException extends RuntimeException {
		public policyNotFoundException(String message) {
			super(message);
		}
	}

	// dispatch events related to the entity
	/*This method is responsible for dispatching domain events associated with a given RetrievePolicy entity. It takes the entity as a parameter and uses the domainEventService to publish the domain events associated with it. The Publish method of the domainEventService is called with the domainEvents list of the RetrievePolicy entity as an argument, which triggers the handling of these events by the relevant subscribers.*/
	public void DispatchEvents(Policy entity) {
		domainEventService.Publish(entity.domainEvents);
	}

}
