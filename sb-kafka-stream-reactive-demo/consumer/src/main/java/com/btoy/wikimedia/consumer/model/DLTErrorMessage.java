package com.btoy.wikimedia.consumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_dlt_messages")
@AllArgsConstructor
@NoArgsConstructor
public class DLTErrorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Boolean isConsumed;
    private LocalDateTime creationTime;
}
