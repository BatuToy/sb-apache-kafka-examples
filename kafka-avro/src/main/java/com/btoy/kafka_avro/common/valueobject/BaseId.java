package com.btoy.kafka_avro.common.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {
    private final T val;
    
    public T getValue() {
        return val;
    }

    public BaseId(T val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) object;
        return Objects.equals(val, baseId.val);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }
}
