package com.acme.Controller;

import com.acme.DTO.OrderRequestDTO;
import com.acme.DTO.OrderResponseDTO;
import com.acme.DTO.PaymentResponseDTO;
import com.acme.Event.CreatePaymentEvent;
import com.acme.Service.OrchetrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrchetrationController {

    @Autowired
    private OrchetrationService service;
    @PostMapping("/create")
    public OrderResponseDTO CreateOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return service.sendRequest(orderRequestDTO);
    }

    @PostMapping("/makepayment")
    public PaymentResponseDTO makePayment(@RequestBody CreatePaymentEvent createPaymentEvent){
        return service.sendRequestToPayment(createPaymentEvent);
    }
}
