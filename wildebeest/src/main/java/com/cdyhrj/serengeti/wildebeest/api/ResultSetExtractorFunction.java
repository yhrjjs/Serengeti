package com.cdyhrj.serengeti.wildebeest.api;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultSetExtractorFunction<T> {
    T apply(ResultSet t);
}
