package com.btoy.kafka_avro.domain.valueObject;

import com.btoy.kafka_avro.common.valueobject.BaseId;

import java.util.UUID;
public class EmployeeId extends BaseId<UUID> {
    public EmployeeId(UUID value) {
        super(value);
    }
}
