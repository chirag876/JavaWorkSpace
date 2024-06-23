package com.AcordApi.Application.Common.Interface;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;

@Repository
public interface IPolicyDataExtrationDataAccess {

	public PolicyDataExtration addData(PolicyDataExtration policyDataExtration);
	public List<PolicyDataExtration> getData();
}
