package com.btoy.wikimedia.producer.services.impl;

import com.btoy.wikimedia.producer.config.kafka.KafkaPublishMessageService;
import com.btoy.wikimedia.producer.payload.WikimediaStreamDataDto;
import com.btoy.wikimedia.producer.services.WikimediaStreamConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

import static com.btoy.wikimedia.producer.util.Statics.*;

@Service
@Slf4j
public class WikimediaStreamConsumerServiceImpl implements WikimediaStreamConsumerService {

    private final WebClient webClient;
    private final KafkaPublishMessageService kafkaPublishMessageService;

    public WikimediaStreamConsumerServiceImpl(WebClient.Builder webClientBuilder, KafkaPublishMessageService kafkaPublishMessageService) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.kafkaPublishMessageService = kafkaPublishMessageService;
    }

    @Override
    public void consumeWikimediaStreamAndPublishMessage(){
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, TOPIC_NAME_WIKIMEDIA);
        headers.put(KafkaHeaders.KEY, WIKIMEDIA_STREAM_KEY);
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(WikimediaStreamDataDto.class)
                .subscribe( data -> {
                    GenericMessage<WikimediaStreamDataDto> message = new GenericMessage<>(data, headers);
                    kafkaPublishMessageService.sendMessage(message);
                });
    }
}

