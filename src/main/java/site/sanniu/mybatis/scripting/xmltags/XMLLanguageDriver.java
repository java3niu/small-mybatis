package site.sanniu.mybatis.scripting.xmltags;

import org.dom4j.Element;
import site.sanniu.mybatis.executor.parameter.ParameterHandler;
import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.scripting.LanguageDriver;
import site.sanniu.mybatis.scripting.defaults.DefaultParameterHandler;
import site.sanniu.mybatis.session.Configuration;

/**
 * XML语言驱动器
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }



}
