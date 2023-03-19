package com.cdyhrj.serengeti.wildebeest.select;

import com.cdyhrj.serengeti.wildebeest.table.Table;
import lombok.Data;

@Data
public class From {
    private String tableName;
    private Table table;

    public static From of(String tableName) {
        From from = new From();
        from.tableName = tableName;

        return from;
    }

    public static From of(Table table) {
        From from = new From();
        from.table = table;
        from.tableName = table.getName();

        return from;
    }
}
