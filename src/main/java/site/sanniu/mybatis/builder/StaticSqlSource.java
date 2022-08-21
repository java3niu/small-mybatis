package site.sanniu.mybatis.builder;

import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.ParameterMapping;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.session.Configuration;

import java.util.List;

/**
 * 静态SQL源码
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }



}
