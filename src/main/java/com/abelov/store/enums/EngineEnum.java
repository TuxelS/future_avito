package com.abelov.store.enums;

import lombok.Getter;

@Getter
public enum EngineEnum {
    PETROL(type = "Бензин"),
    GAS(type = "Газ"),
    ELECTRIC(type = "Электро"),
    HYBRID(type = "Гибрид"),
    DIESEL(type = "Дизель");

    private static String type;

    EngineEnum(String s) {
    }
}
