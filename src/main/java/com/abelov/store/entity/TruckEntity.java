package com.abelov.store.entity;

import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(schema = "transport" , name = "truck")
public class TruckEntity extends TransportEntity{
    private double cargoCapacity;     // Грузоподъёмность (тонны)
    private double cargoAreaLength;   // Длина грузовой площадки (м)
    private boolean hasTrailer;       // Наличие прицепа

    public TruckEntity(){}

    public TruckEntity(String owner, String name, StatusEnum status, String price,
                       String description, LocalDateTime created_at, LocalDateTime updated_at,
                       String color, Integer manufactureYear, String brand, String manufactureCountry,
                       double cargoCapacity, double cargoAreaLength, boolean hasTrailer) {
        super(owner, name, status, price, description, created_at,
                updated_at, color, manufactureYear, brand, manufactureCountry);
        this.cargoCapacity = cargoCapacity;
        this.cargoAreaLength = cargoAreaLength;
        this.hasTrailer = hasTrailer;
    }
}
