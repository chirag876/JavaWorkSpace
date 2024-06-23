package com.acme.Repository;

import com.acme.Entity.Item;
import com.acme.Service.InventoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;



@Repository
public interface ItemRepository extends MongoRepository<Item, Integer> {

}

