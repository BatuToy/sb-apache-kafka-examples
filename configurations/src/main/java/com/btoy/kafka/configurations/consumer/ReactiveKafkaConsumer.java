package com.btoy.kafka.configurations.consumer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReactiveKafkaConsumer {

    Map<String, Object> options = new HashMap<String, Object>();

    public void setOptions(){
        options.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        options.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        options.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserialize.class);
        options.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    }

    

}
