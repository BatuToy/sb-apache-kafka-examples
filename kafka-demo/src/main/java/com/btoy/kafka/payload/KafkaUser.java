package com.btoy.kafka.payload;

import lombok.Data;
import lombok.Generated;

import java.util.UUID;

@Data
public class KafkaUser {
    private String id;
    private String name;
    private String lastName;
}
