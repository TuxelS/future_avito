package com.abelov.store.entity;

import com.abelov.store.enums.CarTypeEnum;
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
@Table(schema = "transport", name = "car")
public class CarEntity extends TransportEntity{
    @Enumerated(value = EnumType.STRING)
    private CarTypeEnum carType;

    @Enumerated(value = EnumType.STRING)
    private EngineEnum engineType;

    private Integer carMileage;

    public CarEntity(){
    }

    public CarEntity(String owner, String name, StatusEnum status,
                     String price, String description, LocalDateTime created_at,
                     LocalDateTime updated_at, String color, Integer manufactureYear,
                     String brand, String manufactureCountry, CarTypeEnum carType, EngineEnum engineType, Integer carMileage) {
        super(owner, name, status, price, description, created_at, updated_at,
                color, manufactureYear, brand, manufactureCountry);
        this.carType = carType;
        this.engineType = engineType;
        this.carMileage = carMileage;
    }
}
