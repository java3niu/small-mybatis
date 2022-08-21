package site.sanniu.mybatis.scripting;

import org.dom4j.Element;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.session.Configuration;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
