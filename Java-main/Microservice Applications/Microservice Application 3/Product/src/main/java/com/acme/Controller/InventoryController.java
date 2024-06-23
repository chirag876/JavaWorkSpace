package com.acme.Controller;


import com.acme.Entity.Item;
import com.acme.Event.CreateItemEvent;
import com.acme.Service.InventoryService;
import com.acme.dto.InventoryRequestDTO;
import com.acme.dto.InventoryResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);
    @Autowired
    private InventoryService service;

    @PostMapping("/deduct")
    public InventoryResponseDTO deduct(@RequestBody final InventoryRequestDTO requestDTO){
        return this.service.deductInventory(requestDTO);
    }

    @PostMapping("/add")
    public String add(@RequestBody final CreateItemEvent requestDTO){
       return this.service.addInventory(requestDTO);
    }

    @GetMapping("/quantity/{id}")
    private Integer getQuantity( @PathVariable int id){
        return service.getQuantity(id);
    }
    @GetMapping("/all")
    private  List<Item> getAll(){
        return service.getAll();
    }

}
