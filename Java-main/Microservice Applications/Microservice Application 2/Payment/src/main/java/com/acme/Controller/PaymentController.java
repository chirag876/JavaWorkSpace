package com.acme.Controller;

import com.acme.Entity.Payment;
import com.acme.Event.CreatePaymentEvent;
import com.acme.Service.PaymentService;
import com.acme.dto.PaymentRequestDTO;
import com.acme.dto.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/debit")
    public PaymentResponseDTO debit(@RequestBody PaymentRequestDTO paymentRequestDTO){
        return this.paymentService.debit(paymentRequestDTO);
    }

    @PostMapping("/credit")
    public  void credit(@RequestBody PaymentRequestDTO paymentRequestDTO){
        this.paymentService.credit(paymentRequestDTO);
    }

    @PostMapping("/makePayment")
    public PaymentResponseDTO makePayment(@RequestBody CreatePaymentEvent payment){
        return paymentService.makePayment(payment);
    }
}
