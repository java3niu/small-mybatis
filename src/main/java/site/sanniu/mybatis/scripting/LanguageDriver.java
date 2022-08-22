package site.sanniu.mybatis.scripting;

import org.dom4j.Element;
import site.sanniu.mybatis.executor.parameter.ParameterHandler;
import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.session.Configuration;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);



}
