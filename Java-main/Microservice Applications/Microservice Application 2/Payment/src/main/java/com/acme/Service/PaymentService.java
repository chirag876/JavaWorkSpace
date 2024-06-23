package com.acme.Service;

import com.acme.Entity.Orders;
import com.acme.Entity.Payment;
import com.acme.Enum.PaymentStatus;
import com.acme.Event.CreatePaymentEvent;
import com.acme.Repository.OrderRepo;
import com.acme.Repository.PaymentRepository;
import com.acme.dto.OrderResponseDTO;
import com.acme.dto.PaymentRequestDTO;
import com.acme.dto.PaymentResponseDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepo orderRepo;
    private Map<Integer, Double> userBalanceMap;

    Logger log
            = Logger.getLogger(
            PaymentService.class.getName());

    @Autowired
    private OrderRepo repo;

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



    @KafkaListener(
            topicPartitions = @org.springframework.kafka.annotation.TopicPartition(
                    topic = "topic_j1", partitions = {"1"}
            ),groupId = "testpaymentorder")
    public void processOrderEvents(OrderResponseDTO orders) {

        repo.save(orders);
    }


    public void credit(final PaymentRequestDTO requestDTO){

        this.userBalanceMap.computeIfPresent(requestDTO.getUserId(), (k, v) -> v + requestDTO.getAmount());
        log.info("Payment add in account");
    }

//    public Payment makePayment(CreatePaymentEvent createPaymentEvent){
//        Payment payment = new Payment();
//        payment.setPaymentId(UUID.randomUUID());
//        payment.setAmount(getPaymentDetails(createPaymentEvent.getOrderId()).getAmount());
//        payment.setUserId(getPaymentDetails(createPaymentEvent.getOrderId()).getUserId());
//        payment.setPaymentStatus(PaymentStatus.REJECTED);
//        if (createPaymentEvent.getAmount() >= getPaymentDetails(createPaymentEvent.getOrderId()).getAmount()){
//            payment.setPaymentStatus(PaymentStatus.APPROVED);
//            log.info("payment: "+ PaymentStatus.APPROVED);
//        }
//         paymentRepository.save(payment);
//        return payment;
//    }

    public PaymentResponseDTO  makePayment(CreatePaymentEvent createPaymentEvent){
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        Payment payment = new Payment();
        responseDTO.setPaymentId(UUID.randomUUID());
        responseDTO.setOrderId(createPaymentEvent.getOrderId());
        responseDTO.setAmount(getPaymentDetails(createPaymentEvent.getOrderId()).getAmount());
        responseDTO.setUserId(getPaymentDetails(createPaymentEvent.getOrderId()).getUserId());
        responseDTO.setStatus(PaymentStatus.REJECTED);
        if (createPaymentEvent.getAmount() >= getPaymentDetails(createPaymentEvent.getOrderId()).getAmount()){
            responseDTO.setStatus(PaymentStatus.APPROVED);
            log.info("payment: "+ PaymentStatus.APPROVED);
        }
        paymentRepository.save( changeDTOEntity(createPaymentEvent));
        return responseDTO;
    }

    private OrderResponseDTO getPaymentDetails(UUID odrerId){
//       Optional<OrderResponseDTO> responseDTO =  orderRepo.findById(odrerId);

        for ( OrderResponseDTO responceDTO:orderRepo.findAll()  ) {
            if (odrerId.equals(responceDTO.getOrderId())){
                return responceDTO;
            }

        }
       return null;


    }

    private  Payment changeDTOEntity(CreatePaymentEvent createPaymentEvent){
        Payment payment  =new Payment();
        payment.setPaymentId(UUID.randomUUID());
        payment.setOrderId(createPaymentEvent.getOrderId());
        payment.setAmount(getPaymentDetails(createPaymentEvent.getOrderId()).getAmount());
        payment.setUserId(getPaymentDetails(createPaymentEvent.getOrderId()).getUserId());
        payment.setPaymentStatus(PaymentStatus.REJECTED);
        if (createPaymentEvent.getAmount() >= getPaymentDetails(createPaymentEvent.getOrderId()).getAmount()){
            payment.setPaymentStatus(PaymentStatus.APPROVED);
            log.info("payment: "+ PaymentStatus.APPROVED);
        }
        return payment;
    }

}
