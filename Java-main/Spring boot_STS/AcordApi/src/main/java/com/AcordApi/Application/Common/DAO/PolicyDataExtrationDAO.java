package com.AcordApi.Application.Common.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;

@Repository
@EnableJpaRepositories
public interface PolicyDataExtrationDAO extends JpaRepository<PolicyDataExtration, UUID> {

}
