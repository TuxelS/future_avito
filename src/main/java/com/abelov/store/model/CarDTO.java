package com.abelov.store.model;

import com.abelov.store.enums.CarTypeEnum;
import com.abelov.store.enums.EngineEnum;
import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarDTO implements Serializable {
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;
    private String color;
    private Integer manufactureYear;
    private String brand;
    private String manufactureCountry;
    @Enumerated(value = EnumType.STRING)
    private CarTypeEnum carType;
    @Enumerated(value = EnumType.STRING)
    private EngineEnum engineType;
    private Integer carMileage;
}
