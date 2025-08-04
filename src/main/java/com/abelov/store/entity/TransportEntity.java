package com.abelov.store.entity;

import com.abelov.store.entity.ItemEntity;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "transport")
public abstract class TransportEntity extends ItemEntity {
    private Integer mileage;
    private String color;
    private Integer manufactureYear;
    private String brand;
    private String manufactureCountry;
    @Enumerated(value = EnumType.STRING)
    private EngineEnum engineType;

    public TransportEntity(){
    }

    public TransportEntity(String owner, String name, StatusEnum status, String price, String description, LocalDateTime created_at, LocalDateTime updated_at, Integer mileage, String color, Integer manufactureYear, String brand, String manufactureCountry, EngineEnum engineType) {
        super(owner, name, status, price, description, created_at, updated_at);
        this.mileage = mileage;
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.brand = brand;
        this.manufactureCountry = manufactureCountry;
        this.engineType = engineType;
    }
}
