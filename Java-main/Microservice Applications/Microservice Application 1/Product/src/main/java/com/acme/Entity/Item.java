package com.acme.Entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;
import org.springframework.data.annotation.Id;


@Data
@ToString
public class Item {

	@Id
    private UUID id;
    private Integer itemId;
    private Double price;
    @Column( name = "stock_available")
    private Integer stockAvailable;
}
