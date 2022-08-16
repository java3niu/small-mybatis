package site.sanniu.mybatis.session;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.datasource.druid.DruidDataSourceFactory;
import site.sanniu.mybatis.datasource.pooled.PooledDataSource;
import site.sanniu.mybatis.datasource.pooled.PooledDataSourceFactory;
import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSource;
import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import site.sanniu.mybatis.executor.Executor;
import site.sanniu.mybatis.executor.SimpleExecutor;
import site.sanniu.mybatis.executor.resultset.DefaultResultSetHandler;
import site.sanniu.mybatis.executor.resultset.ResultSetHandler;
import site.sanniu.mybatis.executor.statement.PreparedStatementHandler;
import site.sanniu.mybatis.executor.statement.StatementHandler;
import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.Environment;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.mapping.XNode;
import site.sanniu.mybatis.transaction.Transaction;
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


    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql){
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    public Executor newExecutor(Transaction transaction){
        return new SimpleExecutor(this,transaction);
    }

    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql){
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }
}
