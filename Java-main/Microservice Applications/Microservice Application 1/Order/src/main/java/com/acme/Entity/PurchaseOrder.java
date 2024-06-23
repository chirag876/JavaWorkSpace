package com.acme.Entity;


import com.acme.Enum.OrderStatus;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@ToString
public class PurchaseOrder {

    @Id
    private UUID id;
    private Integer userId;
    private Integer productId;
    private Double price;
    private OrderStatus status;

}