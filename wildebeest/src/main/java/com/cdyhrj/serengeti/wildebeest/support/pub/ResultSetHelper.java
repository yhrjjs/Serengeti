package com.cdyhrj.serengeti.wildebeest.support.pub;

import com.google.common.collect.Lists;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public final class ResultSetHelper {
    public static List<ColumnMeta> getMetaList(ResultSet resultSet) throws SQLException {
        List<ColumnMeta> metaList = Lists.newArrayList();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int size = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= size; i++) {
            metaList.add(ColumnMeta.of(resultSetMetaData.getColumnName(i), resultSetMetaData.getColumnType(i)));
        }

        return metaList;
    }
}
