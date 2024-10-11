package com.btoy.wikimedia.consumer.repository;

import com.btoy.wikimedia.consumer.model.WikimediaStreamData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaStreamDataRepository extends JpaRepository<WikimediaStreamData, Long> {}
