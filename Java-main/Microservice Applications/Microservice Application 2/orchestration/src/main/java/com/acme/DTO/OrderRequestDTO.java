package com.acme.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderRequestDTO {

    private Integer userId;
    private Integer productId;
    private UUID orderId =UUID.randomUUID();

}