package site.sanniu.mybatis.session;

import site.sanniu.mybatis.builder.xml.XmlConfigBuilder;
import site.sanniu.mybatis.session.defaults.DefaultSqlSessionFactory;
import java.io.Reader;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration){
        return new DefaultSqlSessionFactory(configuration);
    }
}
