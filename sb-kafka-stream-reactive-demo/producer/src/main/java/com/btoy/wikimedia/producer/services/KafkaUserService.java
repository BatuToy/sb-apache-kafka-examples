package com.btoy.wikimedia.producer.services;

import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;

public interface KafkaUserService {
    void sendKafkaUserDtoToKafkaServer(KafkaUserDto kafkaUserDto);
}
