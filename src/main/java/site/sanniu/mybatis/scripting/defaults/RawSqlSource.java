package site.sanniu.mybatis.scripting.defaults;

import site.sanniu.mybatis.builder.SqlSourceBuilder;
import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.scripting.xmltags.DynamicContext;
import site.sanniu.mybatis.scripting.xmltags.SqlNode;
import site.sanniu.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }



}
