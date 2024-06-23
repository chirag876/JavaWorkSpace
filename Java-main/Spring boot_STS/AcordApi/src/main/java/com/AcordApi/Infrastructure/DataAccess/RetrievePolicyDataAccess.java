package com.AcordApi.Infrastructure.DataAccess;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.AcordApi.Application.Common.DAO.RetrievePolicyDAO;
import com.AcordApi.Application.Common.Interface.IDomainEventService;
import com.AcordApi.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.AcordApi.Application.Domain.Entity.RetrievePolicy;
import com.AcordApi.Infrastructure.DataAccess.RetrievePolicyDataAccess.retrievePolicyNotFoundException;

@Service
public class RetrievePolicyDataAccess implements IRetrievePolicyDataAccess{
	
	// create a logger object to log events and errors
	Logger _logger = LoggerFactory.getLogger(RetrievePolicyDAO.class);

	@Autowired
	private RetrievePolicyDAO retrievepolicyDao;
	
	@Autowired
	private IDomainEventService domainEventService;

	// Add a new RetrievePolicy entity to the database
	@Override
	public RetrievePolicy AddPolicy(RetrievePolicy retrievepolicy) {
		try {
			_logger.trace("ContactDataAccess.AddContact - In process");

			// save the RetrievePolicy entity using the DAO object
			retrievepolicyDao.save(retrievepolicy);

		} catch (Exception ex) {
			_logger.error("ContactDataAccess.AddContact" + ex.getMessage());

		}

		// dispatch events related to the entity
		DispatchEvents(retrievepolicy);

		// return the saved entity
		return retrievepolicy;
	}

	// Get a list of all RetrievePolicy entities from the database
	@Override
	public List<RetrievePolicy> GetList() {
		return retrievepolicyDao.findAll();
	}

	// Get a RetrievePolicy entity by its unique id
	public RetrievePolicy GetById(UUID id) {
		return retrievepolicyDao.getById(id);
	}

	// Update an existing RetrievePolicy entity in the database
	@Override
	public RetrievePolicy Update(RetrievePolicy retrievepolicy) {
		return retrievepolicyDao.save(retrievepolicy);
	}

	// Delete a RetrievePolicy entity from the database by its unique id
	public UUID delete(UUID id) {
		try {
			retrievepolicyDao.deleteById(id);
			return null;
		} catch (EmptyResultDataAccessException e) {
			// throw a custom exception if the entity is not found
			throw new retrievePolicyNotFoundException("Could not find policy with id " + id);
		}
	}

	// define a custom exception to be thrown when a RetrievePolicy entity is not found
	public class retrievePolicyNotFoundException extends RuntimeException {
		public retrievePolicyNotFoundException(String message) {
			super(message);
		}
	}

	// dispatch events related to the entity
	/*This method is responsible for dispatching domain events associated with a given RetrievePolicy entity. It takes the entity as a parameter and uses the domainEventService to publish the domain events associated with it. The Publish method of the domainEventService is called with the domainEvents list of the RetrievePolicy entity as an argument, which triggers the handling of these events by the relevant subscribers.*/
	public void DispatchEvents(RetrievePolicy entity) {
		domainEventService.Publish(entity.domainEvents());
	}

}
