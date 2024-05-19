package com.SampleProject.CQRS.ToDo.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SampleProject.CQRS.ToDo.Entity.ToDo;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Integer> {

}
