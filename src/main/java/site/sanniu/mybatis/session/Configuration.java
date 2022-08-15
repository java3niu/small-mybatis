package site.sanniu.mybatis.session;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.datasource.druid.DruidDataSourceFactory;
import site.sanniu.mybatis.datasource.pooled.PooledDataSource;
import site.sanniu.mybatis.datasource.pooled.PooledDataSourceFactory;
import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSource;
import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import site.sanniu.mybatis.mapping.Environment;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.mapping.XNode;
import site.sanniu.mybatis.transaction.jdbc.JdbcTransaction;
import site.sanniu.mybatis.transaction.jdbc.JdbcTransactionFactory;
import site.sanniu.mybatis.type.TypeAliasRegistry;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class Configuration {

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 环境
     */
    protected Environment environment;

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();


    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public TypeAliasRegistry getAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

}
