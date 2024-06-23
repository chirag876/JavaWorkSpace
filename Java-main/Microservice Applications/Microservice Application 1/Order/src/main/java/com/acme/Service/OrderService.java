package com.acme.Service;

import com.acme.Entity.PurchaseOrder;
import com.acme.Enum.OrderStatus;
import com.acme.Repository.PurchaseOrderRepository;
import com.acme.dto.OrchestratorRequestDTO;
import com.acme.dto.OrderRequestDTO;
import com.acme.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class OrderService {

    // product price map
    private static final Map<Integer, Double> PRODUCT_PRICE =  Map.of(
            1, 100d,
            2, 200d,
            3, 30000d
    );

    Logger log
            = Logger.getLogger(
            OrderService.class.getName());

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private Sinks.Many<OrchestratorRequestDTO> sink;

    public Mono<PurchaseOrder> createOrder(OrderRequestDTO orderRequestDTO){
        return this.purchaseOrderRepository.save(this.dtoToEntity(orderRequestDTO))
                .doOnNext(e -> orderRequestDTO.setOrderId(e.getId()))
                .doOnNext(e -> this.emitEvent(orderRequestDTO));
    }

    public Flux<OrderResponseDTO> getAll() {
        return this.purchaseOrderRepository.findAll()
                .map(this::entityToDto);
    }

    private void emitEvent(OrderRequestDTO orderRequestDTO){
        this.sink.tryEmitNext(this.getOrchestratorRequestDTO(orderRequestDTO));
    }

    private PurchaseOrder dtoToEntity(final OrderRequestDTO dto){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(dto.getOrderId());
        purchaseOrder.setProductId(dto.getProductId());
        purchaseOrder.setUserId(dto.getUserId());
        purchaseOrder.setStatus(OrderStatus.CREATED);
        purchaseOrder.setPrice(PRODUCT_PRICE.get(purchaseOrder.getProductId()));
        return purchaseOrder;
    }

    private OrderResponseDTO entityToDto(final PurchaseOrder purchaseOrder){
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(purchaseOrder.getId());
        dto.setProductId(purchaseOrder.getProductId());
        dto.setUserId(purchaseOrder.getUserId());
        dto.setStatus(purchaseOrder.getStatus());
        dto.setAmount(purchaseOrder.getPrice());
        log.info("All Order method called");
        return dto;
    }

    public OrchestratorRequestDTO getOrchestratorRequestDTO(OrderRequestDTO orderRequestDTO){
        OrchestratorRequestDTO requestDTO = new OrchestratorRequestDTO();
        requestDTO.setUserId(orderRequestDTO.getUserId());
        requestDTO.setAmount(PRODUCT_PRICE.get(orderRequestDTO.getProductId()));
        requestDTO.setOrderId(orderRequestDTO.getOrderId());
        requestDTO.setProductId(orderRequestDTO.getProductId());


        log.info(" Orchestrator called....");
        return requestDTO;
    }
    //    @KafkaListener(topics = "topic_j2",groupId = "product_and_order")
//    public void processProductEvents(Item item) {
//        itemRepository.save(item);
//
//
//    }

    //    @Autowired
//    private ItemRepository itemRepository;

}
