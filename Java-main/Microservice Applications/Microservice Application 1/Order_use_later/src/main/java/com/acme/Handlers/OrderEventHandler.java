package com.acme.Handlers;


//import com.acme.Service.OrderEventUpdateService;
import com.acme.dto.OrchestratorRequestDTO;
import com.acme.dto.OrchestratorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

//@Configuration
//public class OrderEventHandler {
//
//    @Autowired
//    private Flux<OrchestratorRequestDTO> flux;
//
//    @Autowired
//    private OrderEventUpdateService service;
//
//    @Bean
//    public Supplier<Flux<OrchestratorRequestDTO>> supplier(){
//        return () -> flux;
//    };
//
//    @Bean
//    public Consumer<Flux<OrchestratorResponseDTO>> consumer(){
//        return f -> f
//                .doOnNext(c -> System.out.println("Consuming :: " + c))
//                .flatMap(responseDTO -> this.service.updateOrder(responseDTO))
//                .subscribe();
//    };

//}
