//package com.voucherz.voucherservice.api.producer;
//
//import com.voucherz.voucherservice.VoucherserviceApplication;
//import com.voucherz.voucherservice.api.event.AuditMessage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuditProducer {
//    private static final Logger log = LoggerFactory.getLogger(AuditProducer.class);
//
//    private final RabbitTemplate rabbitTemplate;
//    public AuditProducer(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendAudit(AuditMessage message ){
//        log.info("Sending Audit...");
//        System.out.println(message);
//        rabbitTemplate.convertAndSend(VoucherserviceApplication.EXCHANGE_NAME,VoucherserviceApplication.ROUTING_KEY, message);
//
//    }
//}
