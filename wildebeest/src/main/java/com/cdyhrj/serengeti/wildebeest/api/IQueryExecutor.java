package com.cdyhrj.serengeti.wildebeest.api;

import java.sql.ResultSet;
import java.util.Map;
import java.util.function.Function;

/**
 * IQuery
 * <strong>DAO Select</strong>的支撑接口
 *
 * @author <a href="mailto:yhrjjs@126.com">huangqi</a>
 */
public interface IQueryExecutor {
    /**
     * @param sql       sql
     * @param paramMap  参数
     * @param extractor 解析器
     * @param <R>       实体类型
     * @return 实体
     */
    <R> R query(String sql, Map<String, Object> paramMap, Function<ResultSet, R> extractor);
}
