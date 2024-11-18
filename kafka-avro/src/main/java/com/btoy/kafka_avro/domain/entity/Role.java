package com.btoy.kafka_avro.domain.entity;

import com.btoy.kafka_avro.common.entity.BaseEntity;
import com.btoy.kafka_avro.domain.valueObject.EmployeeId;
import com.btoy.kafka_avro.domain.valueObject.RoleId;
import com.btoy.kafka_avro.common.valueobject.RoleType;

public class Role extends BaseEntity<RoleId> {
    private final EmployeeId employeeId;
    private RoleType roleType;

    public void initializeRoleAndRoleType(RoleId roleId){
        super.setId(roleId);
        this.roleType = RoleType.PENDING_ROLE_ASSIGNMENT;
    }

    public Role(EmployeeId employeeId, RoleType roleType) {
        this.employeeId = employeeId;
        this.roleType = roleType;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public RoleType getRoleType() {
        return roleType;
    }

}
