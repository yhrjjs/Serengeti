package com.cdyhrj.serengeti.wildebeest.support.pub;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ColumnMeta {
    public static ColumnMeta of(String name, int type) {
        return new ColumnMeta(name, type);
    }

    @NotNull
    private String name;

    @NotNull
    private int type;
}
