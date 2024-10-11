package com.btoy.wikimedia.consumer.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class Statics {
    public static final String TOPIC_NAME_KAFKA_USER= "kafka-user";
    public static final String TOPIC_NAME_WIKIMEDIA= "wikimedia-btoy-stream";
    public static final String GROUP_ID_KAFKA_USER= "kafka-user-group";
    public static final String GROUP_ID_WIKIMEDIA= "wikimedia";
    public static final Integer ONE= 1;
}
