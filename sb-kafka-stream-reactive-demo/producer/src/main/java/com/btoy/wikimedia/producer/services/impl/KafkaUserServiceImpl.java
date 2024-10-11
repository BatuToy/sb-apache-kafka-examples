package com.btoy.wikimedia.producer.services.impl;

import com.btoy.wikimedia.producer.config.kafka.KafkaPublishMessageService;
import com.btoy.wikimedia.producer.services.KafkaUserService;
import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.btoy.wikimedia.producer.util.Statics.*;
import static org.springframework.kafka.support.KafkaHeaders.*;

@Service
@RequiredArgsConstructor
public class KafkaUserServiceImpl implements KafkaUserService {

    private final KafkaPublishMessageService kafkaPublishMessageService;

    @Override
    public void
    sendKafkaUserDtoToKafkaServer(KafkaUserDto kafkaUserDto) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(KEY, KAFKA_USER_KEY);
        headers.put(TOPIC, TOPIC_NAME_KAFKA_USER);
        kafkaPublishMessageService.sendMessage(new GenericMessage<>(kafkaUserDto, headers));
    }


}
