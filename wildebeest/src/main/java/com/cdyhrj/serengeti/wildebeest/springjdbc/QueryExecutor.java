package com.cdyhrj.serengeti.wildebeest.springjdbc;

import com.cdyhrj.serengeti.wildebeest.api.IQueryExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class QueryExecutor implements IQueryExecutor {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public <R> R query(String sql, Map<String, Object> paramMap, Function<ResultSet, R> extractor) {
        jdbcTemplate.query(sql, paramMap, rs -> {
            return extractor.apply(rs);
        });
        return null;
    }
}
