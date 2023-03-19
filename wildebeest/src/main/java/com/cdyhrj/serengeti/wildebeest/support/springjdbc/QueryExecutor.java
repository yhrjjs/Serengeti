package com.cdyhrj.serengeti.wildebeest.support.springjdbc;

import com.cdyhrj.serengeti.wildebeest.api.IQueryExecutor;
import com.cdyhrj.serengeti.wildebeest.api.ResultSetExtractorFunction;
import com.cdyhrj.serengeti.wildebeest.api.RowMapperFunction;
import com.cdyhrj.serengeti.wildebeest.support.pub.ColumnMeta;
import com.cdyhrj.serengeti.wildebeest.support.pub.ResultSetHelper;
import com.cdyhrj.serengeti.wildebeest.tools.reflect.Reflect;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class QueryExecutor implements IQueryExecutor {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public <T> T fetch(String sql, Map<String, Object> paramMap, Class<T> tClass) {
        return jdbcTemplate.query(sql, paramMap, rs -> {
            List<ColumnMeta> columnMetaList = ResultSetHelper.getMetaList(rs);
            Reflect reflect = Reflect.onClass(tClass).create();

            for (ColumnMeta meta : columnMetaList) {
                reflect.set(meta.getName(), rs.getObject(meta.getName()));
            }

            return reflect.get();
        });
    }

    @Override
    public <T> T fetch(String sql, Map<String, Object> paramMap, ResultSetExtractorFunction<T> resultSetExtractor) {
        return jdbcTemplate.query(sql, paramMap, resultSetExtractor::apply);
    }

    @Override
    public <T> List<T> query(String sql, Map<String, Object> paramMap, Class<T> tClass) {
        return jdbcTemplate.query(sql, paramMap, new RowMapper<T>() {
            private List<ColumnMeta> columnMetaList;

            @Override
            public T mapRow(ResultSet rs, int rowNum) throws SQLException {
                if (rowNum == 0) {
                    columnMetaList = ResultSetHelper.getMetaList(rs);
                }

                Reflect reflect = Reflect.onClass(tClass).create();

                for (ColumnMeta meta : columnMetaList) {
                    reflect.set(meta.getName(), rs.getObject(meta.getName()));
                }

                return reflect.get();
            }
        });
    }

    @Override
    public <T> List<T> query(String sql, Map<String, Object> paramMap, RowMapperFunction<T> rowMapper) {
        return jdbcTemplate.query(sql, paramMap, rowMapper::mapRow);
    }
}
