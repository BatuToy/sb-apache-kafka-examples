package com.btoy.kafka.controller;

import com.btoy.kafka.payload.KafkaUser;
import com.btoy.kafka.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/string")
    public ResponseEntity<String> publishStringMessage(
            @RequestBody String msg
    ){
        messageService.sendStringPayload(msg);
        return ResponseEntity.ok("Message successfully published to Kafka-Server ");
    }

    @PostMapping(value = "/json")
    public ResponseEntity<KafkaUser> publishJsonMessage(
            @RequestBody KafkaUser kafkaUser
    ) {
        return ResponseEntity.ok(
                messageService.sendJsonPayload(kafkaUser)
        );
    }
}
