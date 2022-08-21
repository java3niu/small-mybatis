package site.sanniu.mybatis.session;

import site.sanniu.mybatis.builder.xml.XMLConfigBuilder;
import site.sanniu.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration){
        return new DefaultSqlSessionFactory(configuration);
    }
}
