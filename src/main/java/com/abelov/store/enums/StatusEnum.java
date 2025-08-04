package com.abelov.store.enums;

public enum StatusEnum {
    PUBLISHED(status = "Опубликовано"),
    CLOSED(status = "Закрыто"),
    FROZEN(status = "Заморожено");

    private static String status;

    StatusEnum(String s) {
    }
}
