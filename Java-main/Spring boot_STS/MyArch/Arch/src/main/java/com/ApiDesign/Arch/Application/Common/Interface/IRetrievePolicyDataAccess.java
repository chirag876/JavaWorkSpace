package com.ApiDesign.Arch.Application.Common.Interface;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;

@Repository
@Transactional
public interface IRetrievePolicyDataAccess {

	public RetrievePolicy AddPolicy(RetrievePolicy retrievepolicy);

	public List<RetrievePolicy> GetList();

	//public RetrievePolicy GetById(int id);

	public RetrievePolicy GetById(UUID id);

	public UUID Delete(UUID id);

	//public RetrievePolicy Update(RetrievePolicy retrievepolicy);

	//int delete(int id);

}
