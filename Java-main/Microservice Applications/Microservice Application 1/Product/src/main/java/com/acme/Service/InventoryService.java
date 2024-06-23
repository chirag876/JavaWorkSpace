package com.acme.Service;


import com.acme.Enum.InventoryStatus;
import com.acme.dto.InventoryRequestDTO;
import com.acme.dto.InventoryResponseDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class InventoryService {

    private Map<Integer, Integer> productInventoryMap;
    Logger log
            = Logger.getLogger(
            InventoryService.class.getName());

    @PostConstruct
    private void init(){
        this.productInventoryMap = new HashMap<>();
        this.productInventoryMap.put(1, 0);
        this.productInventoryMap.put(2, 3);
        this.productInventoryMap.put(3, 4);
    }

    public InventoryResponseDTO deductInventory(final InventoryRequestDTO requestDTO){
        int quantity = this.productInventoryMap.getOrDefault(requestDTO.getProductId(), 0);
        InventoryResponseDTO responseDTO = new InventoryResponseDTO();
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setProductId(requestDTO.getProductId());
        responseDTO.setStatus(InventoryStatus.OUTOFSTOCK);
        if(quantity > 0){
            responseDTO.setStatus(InventoryStatus.INSTOCK);
            this.productInventoryMap.put(requestDTO.getProductId(), quantity - 1);
        }
        else if (quantity== 0) {
            log.info("Product id "+ requestDTO.getProductId() + " OUTOFSTOCK");

        }
        return responseDTO;
    }

    public void addInventory(final InventoryRequestDTO requestDTO){
        this.productInventoryMap
                .computeIfPresent(requestDTO.getProductId(), (k, v) -> v + 1);
    }

}
