package com.acme.Entity;

import com.acme.Enum.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "acme_payment")
public class Payment {

    @Id
    private UUID paymentId;
    private UUID orderId;
    private Double amount;
    private Integer userId;
    private PaymentStatus paymentStatus;

}
