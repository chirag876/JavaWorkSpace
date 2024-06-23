package com.acme.Event;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CreateItemEvent {
    @Id
    private Integer productId;
    private Double amount;
    private String name;
    private  String description;
    private Integer Quantity;
}
