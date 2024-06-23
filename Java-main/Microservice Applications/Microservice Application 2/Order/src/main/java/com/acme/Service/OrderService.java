package com.acme.Service;


import com.acme.dto.OrderRequestDTO;
import com.acme.dto.OrderResponseDTO;

import com.acme.Entity.Item;
import com.acme.Entity.PurchaseOrder;
import com.acme.Enum.OrderStatus;
import com.acme.Event.CreateItemEvent;
import com.acme.Repository.ItemRepository;
import com.acme.Repository.PurchaseOrderRepository;
import com.acme.dto.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.logging.Logger;

@Service
public class OrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    // product price map
    private static final Map<Integer, Double> PRODUCT_PRICE =  Map.of(
            1, 100d,
            2, 200d,
            3, 30000d
    );

    private UUID id = UUID.randomUUID();


    List<OrderResponseDTO> orderList = new ArrayList<>();

    Logger log
            = Logger.getLogger(
            OrderService.class.getName());



    @KafkaListener(
            topicPartitions = @org.springframework.kafka.annotation.TopicPartition(
                    topic = "topic_j1", partitions = {"0"}
            ),groupId = "acmeitemprocess")
    public void processProductEvents(CreateItemEvent createItemEvent) {
        Item item = new Item();
        item.setName(createItemEvent.getName());
        item.setProductId(createItemEvent.getProductId());
        item.setAvailableQuantity(createItemEvent.getQuantity());
        item.setDescription(createItemEvent.getDescription());
        item.setAmount(createItemEvent.getAmount());
        itemRepository.save(item);
    }

    public OrderResponseDTO createNewOrder(OrderRequestDTO orderRequestDTO){

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setOrderId(orderRequestDTO.getOrderId());
        dto.setUserId(orderRequestDTO.getUserId());
        dto.setProductId(orderRequestDTO.getProductId());
        dto.setAmount(getProductDetails(orderRequestDTO.getProductId()).getAmount());

        dto.setStatus(OrderStatus.CANCELLED);
        if (getProductDetails(orderRequestDTO.getProductId()).getAvailableQuantity() >1){
            dto.setStatus(OrderStatus.CREATED);
            if (OrderStatus.CREATED.equals(OrderStatus.CREATED)){
                kafkaTemplate.send("topic_j1", 1, "acmeorderpayment", dto);

            }


        }
        purchaseOrderRepository.save(changeDtoToEntity(orderRequestDTO));

        log.info("Orcheration request receive at the point");
        return dto;
    }

    private PurchaseOrder changeDtoToEntity(OrderRequestDTO orderRequestDTO){



        Item items = getProductDetails(orderRequestDTO.getProductId());

        PurchaseOrder order = new PurchaseOrder();
        order.setOrderId(orderRequestDTO.getOrderId());
        order.setAmount(getProductDetails(orderRequestDTO.getProductId()).getAmount());

        order.setOrderId(orderRequestDTO.getOrderId());
        order.setQuantity(1);
        order.setProductId(orderRequestDTO.getProductId());
        order.setProductName(items.getName());
        return order;

    }

    private Item getProductDetails(int productId){
       Optional<Item> item  =  itemRepository.findById(productId);
       return  item.get();
    }

    public List<PurchaseOrder>  getAll(){
        return purchaseOrderRepository.findAll();
    }


    public OrderResponseDTO updateOrderRequest(PaymentResponseDTO responseDTO){
       Optional<PurchaseOrder> purchaseOrder=  purchaseOrderRepository.findById(responseDTO.getOrderId());
       purchaseOrder.get().setAmount(responseDTO.getAmount());
       purchaseOrder.get().setOrderId(responseDTO.getOrderId());
       purchaseOrder.get().setQuantity(1);
       purchaseOrderRepository.save(purchaseOrder.get());
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setUserId(responseDTO.getUserId());
        orderResponseDTO.setOrderId(responseDTO.getOrderId());
        orderResponseDTO.setAmount(responseDTO.getAmount());
        orderResponseDTO.setStatus(OrderStatus.CANCELLED);


       return orderResponseDTO;

    }



}
