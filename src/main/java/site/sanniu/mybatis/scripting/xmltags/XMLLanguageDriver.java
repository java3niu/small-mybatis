package site.sanniu.mybatis.scripting.xmltags;

import org.dom4j.Element;
import site.sanniu.mybatis.mapping.SqlSource;
import site.sanniu.mybatis.scripting.LanguageDriver;
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


}
