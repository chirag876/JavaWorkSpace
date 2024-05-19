package com.api.design.Infrastructure.DataAccess;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.design.Application.Common.DAO.PolicyDAO;
import com.api.design.Application.Common.Interface.IPolicyDataAccess;
import com.api.design.Application.Domain.Entity.Policy;

@Service
public class PolicyDataAccess implements IPolicyDataAccess  {

	@Autowired
	private PolicyDAO policydao;
	@Override
	public UUID addData(Policy policy) {
		
		policydao.save(policy);
		return policy.getId();
	}

}
