package com.cdyhrj.serengeti.wildebeest.api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true, chain = true)
public class Field {
    public static Field of(String name) {
        Field field = new Field();
        field.name = name;

        return field;
    }

    private String name;
}
