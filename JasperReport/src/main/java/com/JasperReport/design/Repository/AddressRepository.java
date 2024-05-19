package com.JasperReport.design.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JasperReport.design.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}