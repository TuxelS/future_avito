package com.abelov.store.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    PUBLISHED(status = "Опубликовано"),
    CLOSED(status = "Закрыто"),
    FROZEN(status = "Заморожено");

    private static String status;

    StatusEnum(String s) {
    }


}
