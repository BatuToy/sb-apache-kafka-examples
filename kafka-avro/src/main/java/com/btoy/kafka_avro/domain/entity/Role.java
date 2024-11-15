package com.btoy.kafka_avro.domain.entity;

import com.btoy.kafka_avro.common.BaseEntity;
import com.btoy.kafka_avro.domain.valueObject.EmployeeId;
import com.btoy.kafka_avro.domain.valueObject.RoleId;
import com.btoy.kafka_avro.domain.valueObject.RoleType;

public class Role extends BaseEntity<RoleId> {
    private final EmployeeId employeeId;

    private RoleType roleType;

    public Role(RoleId roleId, EmployeeId employeeId, RoleType roleType) {
        super.setId(roleId);
        this.employeeId = employeeId;
        this.roleType = roleType;
    }
}
