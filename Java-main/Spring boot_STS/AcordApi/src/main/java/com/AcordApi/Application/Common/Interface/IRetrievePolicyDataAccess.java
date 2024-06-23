package com.AcordApi.Application.Common.Interface;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.RetrievePolicy;

@Repository
@Transactional
public interface IRetrievePolicyDataAccess {
	
	public RetrievePolicy AddPolicy(RetrievePolicy retrievepolicy);

	public List<RetrievePolicy> GetList();

	public RetrievePolicy GetById(UUID id);

	public RetrievePolicy Update(RetrievePolicy retrievepolicy);

	UUID delete(UUID id);

}
