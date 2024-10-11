package com.btoy.wikimedia.producer.consume;

import com.btoy.wikimedia.producer.payload.WikimediaStreamData;
import com.btoy.wikimedia.producer.produce.WikimediaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducerService wikimediaProducerService;

    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducerService wikimediaProducerService) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikimediaProducerService = wikimediaProducerService;
    }

    public void consumeStreamAndPublishMessage(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(WikimediaStreamData.class)
                .subscribe(wikimediaProducerService::publishMessage);
    }
}

