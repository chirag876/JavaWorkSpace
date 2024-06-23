package com.ApiDesign.Arch.Application.Common.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.ApiDesign.Arch.Application.Domain.Entity.JsonS;

@Repository
@EnableJpaRepositories
public interface JsonDAO extends JpaRepository<JsonS,Integer> {

}
