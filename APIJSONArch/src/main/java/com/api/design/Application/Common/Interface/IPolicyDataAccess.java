package com.api.design.Application.Common.Interface;

import java.util.UUID;

import com.api.design.Application.Domain.Entity.Policy;

public interface IPolicyDataAccess {
	public UUID addData(Policy policy);

}
