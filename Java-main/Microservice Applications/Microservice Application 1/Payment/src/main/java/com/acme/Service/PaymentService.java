package com.acme.Service;

import com.acme.Enum.PaymentStatus;
import com.acme.dto.PaymentRequestDTO;
import com.acme.dto.PaymentResponseDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class PaymentService {

    private Map<Integer, Double> userBalanceMap;

    Logger log
            = Logger.getLogger(
            PaymentService.class.getName());

    @PostConstruct
    private void init(){
        this.userBalanceMap = new HashMap<>();
        this.userBalanceMap.put(1, 0d);
        this.userBalanceMap.put(2, 1000d);
        this.userBalanceMap.put(3, 1000d);
    }

    public PaymentResponseDTO debit(final PaymentRequestDTO requestDTO){
        double balance = this.userBalanceMap.getOrDefault(requestDTO.getUserId(), 0d);
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setAmount(requestDTO.getAmount());
        responseDTO.setUserId(requestDTO.getUserId());
        responseDTO.setOrderId(requestDTO.getOrderId());
        responseDTO.setStatus(PaymentStatus.REJECTED);
        if(balance >= requestDTO.getAmount()){
            responseDTO.setStatus(PaymentStatus.APPROVED);
            this.userBalanceMap.put(requestDTO.getUserId(), balance - requestDTO.getAmount());
        } else if (balance < requestDTO.getAmount()) {
            log.info("User id "+ requestDTO.getUserId() + " Order id "+ requestDTO.getOrderId()+ " CANCELLED  Due to due to insufficient funds ");
            
        }
        log.info("  Order id "+ requestDTO.getOrderId() +  " Payment DONE");
        return responseDTO;
    }

    public void credit(final PaymentRequestDTO requestDTO){

        this.userBalanceMap.computeIfPresent(requestDTO.getUserId(), (k, v) -> v + requestDTO.getAmount());
        log.info("Payment add in account");
    }

}
