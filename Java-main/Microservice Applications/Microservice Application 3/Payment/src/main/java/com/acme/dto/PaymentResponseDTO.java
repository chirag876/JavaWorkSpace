package com.acme.dto;

import com.acme.Enum.PaymentStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class PaymentResponseDTO {
    @Id
    private UUID paymentId;
    private Integer userId;
    private UUID orderId;
    private Double amount;
    private PaymentStatus status;
}
