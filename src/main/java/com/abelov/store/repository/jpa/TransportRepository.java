package com.abelov.store.repository.jpa;

import com.abelov.store.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransportRepository extends JpaRepository<TransportEntity, UUID> {
}
