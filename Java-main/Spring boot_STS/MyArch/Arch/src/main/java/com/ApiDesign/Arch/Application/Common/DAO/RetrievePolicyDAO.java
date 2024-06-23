package com.ApiDesign.Arch.Application.Common.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;



@Repository
@EnableJpaRepositories
public interface RetrievePolicyDAO extends JpaRepository<RetrievePolicy ,UUID> {

}
