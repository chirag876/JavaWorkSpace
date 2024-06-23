package com.ApiDesign.Arch.Infrasturture.DataAccess;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.ApiDesign.Arch.Application.Common.DAO.RetrievePolicyDAO;
import com.ApiDesign.Arch.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;
import com.ApiDesign.Arch.Application.Common.Interface.IDomainEventService;


@Service
public class RetrievePolicyDataAccess implements IRetrievePolicyDataAccess {

	Logger _logger = LoggerFactory.getLogger(RetrievePolicyDAO.class);

	@Autowired
	private RetrievePolicyDAO retrievepolicyDao;
	@Autowired
	private IDomainEventService domainEventService;

	@Override
	public RetrievePolicy AddPolicy(RetrievePolicy retrievepolicy) {

		try {
			_logger.trace("ContactDataAccess.AddContact - In process");

			retrievepolicyDao.save(retrievepolicy);

		} catch (Exception ex) {
			_logger.error("ContactDataAccess.AddContact" + ex.getMessage());

		}
		DispatchEvents(retrievepolicy);
		return retrievepolicy;
	}

	@Override
	public List<RetrievePolicy> GetList() {

		return retrievepolicyDao.findAll();

	}

	public RetrievePolicy GetById(UUID id) {
		return retrievepolicyDao.getById(id);
	}

//	@Override
//	public Contact Update(Contact contact) {
//		return contactDao.save(contact);
//	}
//
	@Override
	public UUID Delete(UUID id) {
		
			retrievepolicyDao.deleteById(id);
			return id;
		
	}
//
//	public class ContactNotFoundException extends RuntimeException {
//		public ContactNotFoundException(String message) {
//			super(message);
//		}
//	}

	public void DispatchEvents(RetrievePolicy entity) {

		domainEventService.Publish(entity.domainEvents());

	}

	
	

}
