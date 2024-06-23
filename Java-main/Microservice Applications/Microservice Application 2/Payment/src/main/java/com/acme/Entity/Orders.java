package com.acme.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Document("acme_order")
public class Orders {

    @Id
    private UUID orderId;
    private int quantity;

    private Product_details productDetails;




}
