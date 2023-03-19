package com.cdyhrj.serengeti.wildebeest.api;

import java.sql.ResultSet;
import java.util.function.Function;

@FunctionalInterface
public interface RowMapperFunction<T> {
    T mapRow(ResultSet rs, int rowNum);
}
