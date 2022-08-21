package site.sanniu.mybatis.session;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.datasource.druid.DruidDataSourceFactory;
import site.sanniu.mybatis.datasource.pooled.PooledDataSourceFactory;
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
import site.sanniu.mybatis.reflection.MetaObject;
import site.sanniu.mybatis.reflection.factory.DefaultObjectFactory;
import site.sanniu.mybatis.reflection.factory.ObjectFactory;
import site.sanniu.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import site.sanniu.mybatis.reflection.wrapper.ObjectWrapperFactory;
import site.sanniu.mybatis.scripting.LanguageDriverRegistry;
import site.sanniu.mybatis.scripting.xmltags.XMLLanguageDriver;
import site.sanniu.mybatis.transaction.Transaction;
import site.sanniu.mybatis.transaction.jdbc.JdbcTransactionFactory;
import site.sanniu.mybatis.type.TypeAliasRegistry;
import site.sanniu.mybatis.type.TypeHandlerRegistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class Configuration {

    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    protected final LanguageDriverRegistry languageRegistry = new LanguageDriverRegistry();

    // 类型处理器注册机
    protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();

    // 对象工厂和对象包装器工厂
    protected ObjectFactory objectFactory = new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

    /**
     * 记载过的mapper
     */
    protected final Set<String> loadedResources = new HashSet<>();

    protected String databaseId;

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);

        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);

        languageRegistry.setDefaultDriverClass(XMLLanguageDriver.class);
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

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

    // 创建元对象
    public MetaObject newMetaObject(Object object) {
        return MetaObject.forObject(object, objectFactory, objectWrapperFactory);
    }

    // 类型处理器注册机
    public TypeHandlerRegistry getTypeHandlerRegistry() {
        return typeHandlerRegistry;
    }

    public boolean isResourceLoaded(String resource) {
        return loadedResources.contains(resource);
    }

    public void addLoadedResource(String resource) {
        loadedResources.add(resource);
    }

    public LanguageDriverRegistry getLanguageRegistry() {
        return languageRegistry;
    }


}
