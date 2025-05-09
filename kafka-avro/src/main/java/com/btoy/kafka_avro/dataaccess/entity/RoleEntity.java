package com.btoy.kafka_avro.dataaccess.entity;

import com.btoy.kafka_avro.common.valueobject.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
@Data
public class RoleEntity {
    @Id
    private UUID roleId;

    @Id
    @Column(name = "EMPLOYEE_ID")
    @OneToMany(mappedBy = "EMPLOYEE", cascade = CascadeType.ALL)
    private EmployeeEntity employeeEntity;

    @Column(name = "ROLE_TYPE")
    private RoleType roleType;
//    @Column(name = "EMPLOYEES")
//    @OneToMany
//    private List<EmployeeEntity> employeeEntityList;
}
