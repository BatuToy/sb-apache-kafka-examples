package com.btoy.wikimedia.consumer.config.mapper;

import com.btoy.wikimedia.consumer.dto.WikimediaStreamDataDto;
import com.btoy.wikimedia.consumer.model.DLTErrorMessage;
import com.btoy.wikimedia.consumer.model.KafkaUser;
import com.btoy.wikimedia.consumer.model.WikimediaStreamData;
import com.btoy.wikimedia.consumer.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {
    private final ModelMapper modelMapper;
    // ToDo: solve the package issue with KafkaUserDto
    public KafkaUser mapToKafkaUser(com.btoy.wikimedia.shared.lib.dto.KafkaUserDto kafkaUserDto){
        return modelMapper.map(kafkaUserDto, KafkaUser.class);
    }

    public KafkaUserDto mapToKafkaUserDto(KafkaUser kafkaUser){
        return modelMapper.map(kafkaUser, KafkaUserDto.class);
    }

    public WikimediaStreamData mapToWikimediaStreamDataDto(WikimediaStreamDataDto wikimediaStreamDataDto){
        return modelMapper.map(wikimediaStreamDataDto, WikimediaStreamData.class);
    }
    public WikimediaStreamDataDto mapToWikimediaStreamDataDto(WikimediaStreamData wikimediaStreamData){
        return modelMapper.map(wikimediaStreamData, WikimediaStreamDataDto.class);
    }

    public DLTErrorMessage mapToDltErrorMessages(Object object){
        return modelMapper.map(object, DLTErrorMessage.class);
    }
}
