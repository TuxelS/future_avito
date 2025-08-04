package com.abelov.store.entity;

import com.abelov.store.enums.CarTypeEnum;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "car")
public class CarEntity extends TransportEntity{
    @Enumerated(value = EnumType.STRING)
    private CarTypeEnum carType;

    public CarEntity(){
    }

    public CarEntity(String owner, String name, StatusEnum status, String price,
                     String description, LocalDateTime created_at, LocalDateTime updated_at,
                     Integer mileage, String color, Integer manufactureYear, String brand,
                     String manufactureCountry,
                     EngineEnum engineType, CarTypeEnum carType) {
        super(owner, name, status, price, description, created_at, updated_at, mileage, color,
                manufactureYear, brand, manufactureCountry, engineType);
        this.carType = carType;
    }
}
