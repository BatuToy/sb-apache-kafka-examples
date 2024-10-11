package com.btoy.wikimedia.producer.controller;

import com.btoy.wikimedia.producer.services.KafkaUserService;
import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/kafka-user")
@RequiredArgsConstructor
public class KafkaUserSendMessageController {
    private final KafkaUserService kafkaUserService;

    @PostMapping
    public ResponseEntity<String> sendKafkaUserMessage(
            @RequestBody KafkaUserDto kafkaUserDto
    ) {
        kafkaUserService.sendKafkaUserDtoToKafkaServer(kafkaUserDto);
        return ResponseEntity.ok(
                "Message has been sent to Kafka-Server"
        );
    }
}
