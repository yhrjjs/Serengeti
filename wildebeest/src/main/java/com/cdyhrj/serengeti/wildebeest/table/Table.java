package com.cdyhrj.serengeti.wildebeest.table;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Table {
    @NotNull
    private String name;

    public static Table of(String name) {
        Table table = new Table(name);

        return table;
    }
}
