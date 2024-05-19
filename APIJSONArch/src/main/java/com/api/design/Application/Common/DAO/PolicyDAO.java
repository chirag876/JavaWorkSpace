package com.api.design.Application.Common.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.api.design.Application.Domain.Entity.Policy;


@Repository
@EnableJpaRepositories
public interface PolicyDAO extends JpaRepository<Policy, UUID> {

}
