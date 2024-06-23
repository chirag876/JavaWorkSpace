package com.AcordApi.Application.Common.Interface;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.Policy;

@Repository
@Transactional
public interface IPolicyDataAccess {
	
	public Policy AddPolicy(Policy policy);

	public List<Policy> GetList();

	public Policy GetById(UUID id);

	public Policy Update(Policy policy);

	public UUID delete(UUID id);

}
