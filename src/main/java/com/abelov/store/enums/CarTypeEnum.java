package com.abelov.store.enums;

public enum CarTypeEnum {
    Sedan(type = "Седан"),
    Hatchback(type = "Хэтчбек"),
    StationWagon(type = "Универсал"),
    SUV(type = "Внедорожник");

    private static String type;

    CarTypeEnum(String s) {
    }
}
