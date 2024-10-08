package com.btoy.wikimedia.producer.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Statics {

    public static final String TOPIC_NAME= "wikimedia-btoy-stream";
    public static final String GROUP_ID= "wikimedia";
    public static final Integer ONE= 1;
}
