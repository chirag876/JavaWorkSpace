package com.acme.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "acme_order")
public class PurchaseOrder {
    @Id
    private UUID orderId;
    private int productId;
    private String productName;
    private double amount;
    private int quantity;

}
