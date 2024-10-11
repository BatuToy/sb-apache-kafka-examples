package com.btoy.wikimedia.producer.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Statics {

    public static final String TOPIC_NAME_WIKIMEDIA= "wikimedia-btoy-stream";
    public static final String TOPIC_NAME_KAFKA_USER= "kafka-user";
    public static final Integer PARTITION= 1;
    public static final String GROUP_ID_WIKIMEDIA= "wikimedia";
    public static final String GROUP_ID_KAFKA_USER = "kafka-user-group";
    public static final String KAFKA_USER_KEY= "kafka-user";
    public static final Integer ONE= 1;
}
