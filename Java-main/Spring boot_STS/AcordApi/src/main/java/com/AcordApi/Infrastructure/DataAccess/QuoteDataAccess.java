package com.AcordApi.Infrastructure.DataAccess;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.AcordApi.Application.Common.DAO.QuoteDAO;
import com.AcordApi.Application.Common.Interface.IDomainEventService;
import com.AcordApi.Application.Common.Interface.IQuoteDataAccess;
import com.AcordApi.Application.Domain.Entity.Quote;
import com.AcordApi.Infrastructure.DataAccess.QuoteDataAccess.quoteNotFoundException;

@Service
public class QuoteDataAccess implements IQuoteDataAccess{
	
	// create a logger object to log events and errors
	Logger _logger = LoggerFactory.getLogger(QuoteDataAccess.class);

	@Autowired
	private QuoteDAO quoteDao;
	
	@Autowired
	private IDomainEventService domainEventService;

	// Add a new RetrievePolicy entity to the database
	@Override
	public Quote AddQuote(Quote quote) {
		try {
			_logger.trace("QuoteDataAccess.AddQuote - In process");

			// save the RetrievePolicy entity using the DAO object
			quoteDao.save(quote);

		} catch (Exception ex) {
			_logger.error("QuoteDataAccess.AddQuote" + ex.getMessage());

		}

		// dispatch events related to the entity
		DispatchEvents(quote);

		// return the saved entity
		return quote;
	}

	// Get a list of all RetrievePolicy entities from the database
	@Override
	public List<Quote> GetList() {
		
		
		return quoteDao.findAll();
	}

	// Get a RetrievePolicy entity by its unique id
	public Quote GetById(UUID id) {
		
		try {
		_logger.trace("QuoteDataAccess.GetById - In process");
		quoteDao.getById(id);
		}
		catch(Exception ex) {
			_logger.trace("QuoteDataAccess.GetById - Could not find quote with id " + id);
		}
		
		//DispatchEvents();
		return null;
		
	}

	// Update an existing RetrievePolicy entity in the database
	@Override
	public Quote Update(Quote quote) {
		
		try {
			_logger.trace("QuoteDataAccess.Update - In process");
			quoteDao.save(quote);
		}
		catch(Exception ex) {
			_logger.trace("QuoteDataAccess.Update -" +ex.getMessage());
		}
		DispatchEvents(quote);
		
		return quote;
		
	}

	// Delete a RetrievePolicy entity from the database by its unique id
	public UUID delete(UUID id) {
		try {
			_logger.trace("QuoteDataAccess.Delete - In process");
			quoteDao.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			// throw a custom exception if the entity is not found
			_logger.trace("QuoteDataAccess.Delete - Could not find quote with id " + id);
			throw new quoteNotFoundException("Could not find quote with id " + id);
		}
	
		return id;
	}

	// define a custom exception to be thrown when a RetrievePolicy entity is not found
	public class quoteNotFoundException extends RuntimeException {
		public quoteNotFoundException(String message) {
			super(message);
		}
	}

	// dispatch events related to the entity
	/*This method is responsible for dispatching domain events associated with a given RetrievePolicy entity. It takes the entity as a parameter and uses the domainEventService to publish the domain events associated with it. The Publish method of the domainEventService is called with the domainEvents list of the RetrievePolicy entity as an argument, which triggers the handling of these events by the relevant subscribers.*/
	public void DispatchEvents(Quote entity) {
		domainEventService.Publish(entity.domainEvents());
	}

}
