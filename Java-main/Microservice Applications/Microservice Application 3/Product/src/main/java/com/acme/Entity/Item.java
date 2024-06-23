package com.acme.Entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

import java.lang.annotation.Documented;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@ToString
@Document(collection = "acme_product")
public class Item {

    @Id
    private Integer productId;
    private Double amount;
    private String name;
    private String description;
    private Integer availableQuantity;
    private Date createdTime;
}
