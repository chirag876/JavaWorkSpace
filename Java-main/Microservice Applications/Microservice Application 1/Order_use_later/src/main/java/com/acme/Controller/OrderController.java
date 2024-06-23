package com.acme.Controller;


import com.acme.Entity.PurchaseOrder;
import com.acme.Service.OrderService;
import com.acme.dto.OrderRequestDTO;
import com.acme.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/create")
    public Mono<PurchaseOrder> createOrder(@RequestBody OrderRequestDTO mono){
        return this.service.createOrder(mono);
    }

    @GetMapping("/all")
    public Flux<OrderResponseDTO> getOrders(){
        return this.service.getAll();
    }

}
