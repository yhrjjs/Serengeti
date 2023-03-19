package com.cdyhrj.serengeti.wildebeest.select;

import com.cdyhrj.serengeti.wildebeest.api.IQueryExecutor;
import com.cdyhrj.serengeti.wildebeest.field.Field;
import com.cdyhrj.serengeti.wildebeest.where.Where;
import com.google.common.collect.ImmutableMap;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Select {
    private IQueryExecutor queryExecutor;

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

    public <T> T fetchInto(Class<T> clazz) {
        return null;
    }

    public <R> R fetchInto(Function<ResultSet, R> extractor) {
        Map<String, Object> paramMap = ImmutableMap.of();

        return this.queryExecutor.query("", paramMap, extractor);
    }
}
