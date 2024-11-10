package com.btoy.kafka_avro.domain.valueObject;

import com.btoy.kafka_avro.common.BaseId;

import java.util.UUID;

public class RoleId extends BaseId<UUID>{
    public RoleId(UUID value) {
        super(value);
    }
}
