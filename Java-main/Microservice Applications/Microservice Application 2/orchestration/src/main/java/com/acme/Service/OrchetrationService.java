package com.acme.Service;

import com.acme.DTO.OrderRequestDTO;
import com.acme.DTO.OrderResponseDTO;
import com.acme.DTO.Payment;
import com.acme.DTO.PaymentResponseDTO;
import com.acme.Enum.OrderStatus;
import com.acme.Enum.PaymentStatus;
import com.acme.Event.CreatePaymentEvent;
import com.acme.Orchestration.OrderWorkflow;
import com.acme.Orchestration.Step.OrderStep;
import com.acme.Orchestration.Workflow;
import com.acme.Orchestration.WorkflowStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class OrchetrationService {

    Logger logger = Logger.getLogger(OrchetrationService.class.getName());

//    private final WebClient webClient;

    @Autowired
    @Qualifier("order")
    private WebClient orderClient;
    @Autowired
    @Qualifier("payment")
    private WebClient paymentClient;




    public OrderResponseDTO sendRequest(OrderRequestDTO requestDTO) {
        logger.info("Orchestration Started.. ");

        OrderResponseDTO orderdto = orderClient
                .post()
                .uri("order/createOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestDTO), OrderRequestDTO.class)
                .retrieve()
                .bodyToMono(OrderResponseDTO.class).block();


        logger.info("Order Status received from Order"+ orderdto.getStatus());

        return orderdto;
    }


    public PaymentResponseDTO sendRequestToPayment(CreatePaymentEvent paymentEvent){
        PaymentResponseDTO responseDTO = paymentClient
                .post()
                .uri("payment/makePayment")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(paymentEvent), CreatePaymentEvent.class)
                .retrieve()
                .bodyToMono(PaymentResponseDTO.class).block();

        logger.info("Payment  Status received from payment "+ responseDTO.getStatus());

        if (responseDTO.getStatus().equals(PaymentStatus.REJECTED)){
            updateOrderRequest(responseDTO);
        }

        return responseDTO;
    }

    private  OrderResponseDTO updateOrderRequest(PaymentResponseDTO requestDTO){

        OrderResponseDTO orderdto = orderClient
                .put()
                .uri("order/updateOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestDTO), PaymentResponseDTO.class)
                .retrieve()
                .bodyToMono(OrderResponseDTO.class).block();


        logger.info("Order Status received from Order"+ orderdto.getStatus());

        return orderdto;


    }



}
