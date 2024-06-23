package com.acme.Entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


@Data
@ToString
//@Document(collection = "test_product")
public class Item {

    @Id
    private Integer productId;
    private Double amount;
    private Integer Quantity;
}
