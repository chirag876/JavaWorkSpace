package com.acme.Repository;

import com.acme.Entity.PurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, UUID> {
}
