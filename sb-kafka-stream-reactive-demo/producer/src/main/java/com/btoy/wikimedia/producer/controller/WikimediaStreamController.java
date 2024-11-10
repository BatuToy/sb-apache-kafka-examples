package com.btoy.wikimedia.producer.controller;

import com.btoy.wikimedia.producer.services.impl.WikimediaStreamConsumerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/wikimedia")
public class WikimediaStreamController {

    private final WikimediaStreamConsumerServiceImpl wikimediaStreamConsumerServiceImpl;

    /**
     * this method is created for triggering the stream process of the wikimedia.(No other reason)
     */
    @GetMapping(value = "/startPublish")
    public ResponseEntity<String> startPublishing() {
        wikimediaStreamConsumerServiceImpl.consumeWikimediaStreamAndPublishMessage();
        return ResponseEntity.ok("Stream has been started.");
    }
}
