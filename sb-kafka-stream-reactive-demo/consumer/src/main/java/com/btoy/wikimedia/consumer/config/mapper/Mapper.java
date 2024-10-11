package com.btoy.wikimedia.consumer.config.mapper;

import com.btoy.wikimedia.consumer.model.KafkaUser;
import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {
    private final ModelMapper modelMapper;

    public KafkaUser mapToEntity(KafkaUserDto kafkaUserDto){
        return modelMapper.map(kafkaUserDto, KafkaUser.class);
    }

    public KafkaUserDto mapToDto(KafkaUser kafkaUser){
        return modelMapper.map(kafkaUser, KafkaUserDto.class);
    }
}
