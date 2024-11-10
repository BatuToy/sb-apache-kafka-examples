package com.btoy.wikimedia.consumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_dlt_error_messages")
@AllArgsConstructor
@NoArgsConstructor
public class DLTErrorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DLT_ERROR_ID")
    private Long id;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "IS_MESSAGE_CONSUMED")
    private Boolean isConsumed;
    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private LocalDateTime creationTime;
}
