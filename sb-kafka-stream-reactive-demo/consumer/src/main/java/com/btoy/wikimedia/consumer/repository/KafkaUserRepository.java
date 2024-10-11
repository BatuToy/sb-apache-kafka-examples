package com.btoy.wikimedia.consumer.repository;

import com.btoy.wikimedia.consumer.model.KafkaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaUserRepository extends JpaRepository<KafkaUser, Long> {}
