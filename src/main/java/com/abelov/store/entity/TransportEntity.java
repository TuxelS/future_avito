package com.abelov.store.entity;

import com.abelov.store.entity.ItemEntity;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(schema = "transport", name = "transport")
public class TransportEntity extends ItemEntity {
    private String color;
    private Integer manufactureYear;
    private String brand;
    private String manufactureCountry;

    public TransportEntity(){
    }

    public TransportEntity(String owner, String name, StatusEnum status,
                           String price, String description, LocalDateTime created_at,
                           LocalDateTime updated_at, String color, Integer manufactureYear,
                           String brand, String manufactureCountry) {
        super(owner, name, status, price, description, created_at, updated_at);
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.brand = brand;
        this.manufactureCountry = manufactureCountry;
    }
}
