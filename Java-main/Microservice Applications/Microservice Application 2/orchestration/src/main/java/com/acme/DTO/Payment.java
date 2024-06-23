package com.acme.DTO;

import com.acme.Enum.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Payment {
    private UUID paymentId;
    private UUID orderId;
    private Double amount;
    private Integer userId;
    private PaymentStatus status;

}
