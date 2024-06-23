package com.acme.Controller;



import com.acme.dto.OrderRequestDTO;
import com.acme.dto.OrderResponseDTO;
import com.acme.Entity.PurchaseOrder;
import com.acme.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

//    @PostMapping("/create")
//    public Mono<PurchaseOrder> createOrder(@RequestBody OrderRequestDTO mono){
//        return this.service.createOrder(mono);
//    }
//
//    @GetMapping("/all")
//    public Flux<OrderResponseDTO> getOrders(){
//        return this.service.getAll();
//    }


    @PostMapping("/createOrder")
    public OrderResponseDTO createNew(@RequestBody OrderRequestDTO orderRequestDTO){
        return this.service.createNewOrder(orderRequestDTO);
    }

    @GetMapping("/all")
    public List<PurchaseOrder> getAll(){
        return this.service.getAll();
    }

}
