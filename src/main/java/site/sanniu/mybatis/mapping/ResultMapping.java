package site.sanniu.mybatis.mapping;

import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.type.JdbcType;
import site.sanniu.mybatis.type.TypeHandler;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }


}
