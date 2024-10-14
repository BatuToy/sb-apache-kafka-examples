package com.btoy.wikimedia.consumer.repository;

import com.btoy.wikimedia.consumer.model.DLTErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DLTErrorMessageRepository extends JpaRepository<DLTErrorMessage, Long> {
}
