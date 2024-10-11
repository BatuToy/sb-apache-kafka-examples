package com.btoy.wikimedia.shared.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaUserDto {
    private String firstName;
    private String lastName;
    private String email;

}
