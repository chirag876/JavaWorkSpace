package com.acme.Repository;

import com.acme.Entity.Orders;
import com.acme.dto.OrderResponseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepo extends MongoRepository<OrderResponseDTO, UUID> {
}
