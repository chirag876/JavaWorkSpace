package com.acme.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class OrderRequestDTO {

    private Integer userId;
    private Integer productId;
    @Id
    private UUID orderId = UUID.randomUUID();

}