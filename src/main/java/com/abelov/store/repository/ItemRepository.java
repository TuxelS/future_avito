package com.abelov.store.repository;

import com.abelov.store.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {
}
