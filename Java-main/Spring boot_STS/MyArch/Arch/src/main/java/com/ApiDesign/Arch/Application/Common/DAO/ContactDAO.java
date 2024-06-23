package com.ApiDesign.Arch.Application.Common.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ApiDesign.Arch.Application.Domain.Entity.Contact;

@Repository
@EnableJpaRepositories
public interface ContactDAO extends JpaRepository<Contact,Integer> {

}
