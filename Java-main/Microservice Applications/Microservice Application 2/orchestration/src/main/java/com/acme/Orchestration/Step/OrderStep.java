package com.acme.Orchestration.Step;

import com.acme.Common.Workflow;
import com.acme.Common.WorkflowStep;
import com.acme.Common.WorkflowStepStatus;
import com.acme.DTO.OrderRequestDTO;
import com.acme.DTO.OrderResponseDTO;
import com.acme.Enum.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class OrderStep implements WorkflowStep {

    @Autowired
    @Qualifier("order")
    private WebClient orderClient;

    private OrderRequestDTO requestDTO;

    public OrderStep(WebClient orderClient, OrderRequestDTO orderRequestDTO) {
        this.orderClient = orderClient;
        this.requestDTO = orderRequestDTO;
    }

    private WorkflowStepStatus stepStatus = WorkflowStepStatus.PENDING;

    @Override
    public WorkflowStepStatus getStatus() {
        return stepStatus;
    }

    @Override
    public Mono<Boolean> process() {

         Mono<Boolean> orderResponce = this.orderClient
                .post()
                .uri("/order/create")
                .body(BodyInserters.fromValue(this.requestDTO))
                .retrieve()
                .bodyToMono(OrderResponseDTO.class)
                .map(r -> r.getStatus().equals(OrderStatus.CREATED))
                .doOnNext(b -> this.stepStatus = b ? WorkflowStepStatus.COMPLETE : WorkflowStepStatus.FAILED);


        return orderResponce;
    }


    @Override
    public Mono<Boolean> revert() {
        return null;
    }
}
