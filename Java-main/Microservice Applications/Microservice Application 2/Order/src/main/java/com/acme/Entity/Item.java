package com.acme.Entity;

//import jakarta.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@ToString
@Document(collection = "acme_product")
@Setter
@Getter
public class Item {

    @Id
    private Integer productId;
    private Double amount;
    private String name;
    private  String description;
    private Integer availableQuantity;
    private Date createdTime;
}
