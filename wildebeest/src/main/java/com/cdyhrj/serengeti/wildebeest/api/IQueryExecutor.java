package com.cdyhrj.serengeti.wildebeest.api;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * IQuery
 * <strong>DAO Select</strong>的支撑接口
 *
 * @author <a href="mailto:yhrjjs@126.com">huangqi</a>
 */
public interface IQueryExecutor {
    <T> T fetch(String sql, Map<String, Object> paramMap, Class<T> tClass);

    /**
     * 查询单个对象
     *
     * @param sql                sql
     * @param paramMap           参数
     * @param resultSetExtractor 结果抽取器
     * @param <T>                实体类型
     * @return 实体
     */
    <T> T fetch(String sql, Map<String, Object> paramMap, ResultSetExtractorFunction<T> resultSetExtractor);

    <T> List<T> query(String sql, Map<String, Object> paramMap, Class<T> tClass);

    /**
     * 查询单个对象
     *
     * @param sql       sql
     * @param paramMap  参数
     * @param rowMapper 行结果抽取器
     * @param <T>       实体类型
     * @return 实体
     */
    <T> List<T> query(String sql, Map<String, Object> paramMap, RowMapperFunction<T> rowMapper);
}
