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
@Table(name = "t_roles")
@Entity
@Data
public class RoleEntity {
    @Id
    @NotNull
    private UUID roleId;
    @NotNull
    @Column(name = "EMPLOYEE_ID")
    private UUID employeeId;
    @NotNull
    @Column(name = "ROLE_TYPE")
    private RoleType roleType;
//    @Column(name = "EMPLOYEES")
//    @OneToMany
//    private List<EmployeeEntity> employeeEntityList;
}
