package com.acme.Event;

import lombok.Data;

import java.util.UUID;
@Data
public class CreatePaymentEvent {
    private UUID orderId;
    private  Double amount;

}
