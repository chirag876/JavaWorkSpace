package com.acme.Repository;


import com.acme.Entity.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DbUser, String> {
}
