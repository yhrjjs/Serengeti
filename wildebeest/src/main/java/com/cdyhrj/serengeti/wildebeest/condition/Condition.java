package com.cdyhrj.serengeti.wildebeest.condition;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Condition {
    @NotNull
    private String name;

    @NotNull
    private Comparator comparator;

    private Object value;

    public static Condition of(String name, Comparator comparator) {
        return new Condition(name, comparator);
    }

    public static Condition of(String name, Comparator comparator, Object value) {
        Condition condition = new Condition(name, comparator);
        condition.setValue(value);

        return condition;
    }
}
