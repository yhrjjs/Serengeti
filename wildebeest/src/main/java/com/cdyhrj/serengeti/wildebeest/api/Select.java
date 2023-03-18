package com.cdyhrj.serengeti.wildebeest.api;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Select {
    public static Select of() {
        return new Select();
    }

    private List<Field> fieldList;
    private From from;
    private Where where;

    public Select field(Field field) {
        this.fieldList.add(field);

        return this;
    }

    public Select fields(Field... fields) {
        return this.fields(Arrays.asList(fields));
    }

    public Select fields(List<Field> fieldList) {
        this.fieldList.addAll(fieldList);

        return this;
    }

    public Select from(From from) {
        this.from = from;

        return this;
    }

    public Select where(Where where) {
        this.where = where;

        return this;
    }

    public Where where() {
        Objects.requireNonNull(this.where, "where object is null");

        return this.where;
    }

    public int count() {
        return 0;
    }
}
