package com.cdyhrj.serengeti.wildebeest;

import java.sql.ResultSet;

@FunctionalInterface
public interface Fn<T> {
    public T apply(ResultSet rs);
}
