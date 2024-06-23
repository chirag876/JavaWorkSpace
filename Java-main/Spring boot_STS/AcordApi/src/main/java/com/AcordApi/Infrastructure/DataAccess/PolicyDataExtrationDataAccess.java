package com.AcordApi.Infrastructure.DataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcordApi.Application.Common.DAO.PolicyDataExtrationDAO;
import com.AcordApi.Application.Common.Interface.IPolicyDataExtrationDataAccess;
import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;


@Service
public class PolicyDataExtrationDataAccess implements IPolicyDataExtrationDataAccess {
	@Autowired
	private PolicyDataExtrationDAO  policyDatadao;
	
	public PolicyDataExtration  addData(PolicyDataExtration policyDataExtration ) {
		
		policyDatadao.save(policyDataExtration);
		return policyDataExtration;
	}
	public List<PolicyDataExtration> getData() {
		 return policyDatadao.findAll();
	}

}
