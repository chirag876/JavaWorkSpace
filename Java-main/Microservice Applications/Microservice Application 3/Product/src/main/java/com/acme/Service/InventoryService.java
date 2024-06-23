package com.acme.Service;


import com.acme.Entity.Item;
import com.acme.Enum.InventoryStatus;
import com.acme.Event.CreateItemEvent;
import com.acme.Repository.ItemRepository;
import com.acme.dto.InventoryRequestDTO;
import com.acme.dto.InventoryResponseDTO;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class InventoryService {

    Logger log = LoggerFactory.getLogger(InventoryService.class);

    private Map<Integer, Integer> productInventoryMap;

    @PostConstruct
    private void init() {
        this.productInventoryMap = new HashMap<>();
        this.productInventoryMap.put(1, 0);
        this.productInventoryMap.put(2, 3);
        this.productInventoryMap.put(3, 4);
    }

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private ItemRepository repository;

    public InventoryResponseDTO deductInventory(final InventoryRequestDTO requestDTO) {
        int quantity = this.productInventoryMap.getOrDefault(requestDTO.getProductId(), 0);
        InventoryResponseDTO responseDTO = new InventoryResponseDTO();
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setProductId(requestDTO.getProductId());
        responseDTO.setStatus(InventoryStatus.OUTOFSTOCK);
        if (quantity > 0) {
            responseDTO.setStatus(InventoryStatus.INSTOCK);
            this.productInventoryMap.put(requestDTO.getProductId(), quantity - 1);
        } else if (quantity == 0) {
            log.info("Product id " + requestDTO.getProductId() + " OUTOFSTOCK");

        }
        return responseDTO;
    }

    public String addInventory(final CreateItemEvent requestDTO) {

        Item item = new Item();
        item.setProductId(requestDTO.getProductId());
        item.setAmount(requestDTO.getAmount());
        item.setName(requestDTO.getName());
        item.setDescription(requestDTO.getDescription());

        item.setAvailableQuantity(requestDTO.getQuantity());
        item.setCreatedTime(Timestamp.from(Instant.now())  );

        repository.save(item);
        log.info("Product Added in database....");
        kafkaTemplate.send("topic_j1", 0, "acmeproductorder",requestDTO);
        log.info("Event sent on topic_j1 " );


        return "Product Added"+ requestDTO.getProductId();
    }

    public Integer getQuantity(int id) {
        Item item = repository.findById(id).get();
        return item.getAvailableQuantity();


    }

    public  List<Item> getAll(){
        return repository.findAll();
    }
}
