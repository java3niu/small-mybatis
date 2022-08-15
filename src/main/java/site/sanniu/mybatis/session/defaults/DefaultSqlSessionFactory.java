package site.sanniu.mybatis.session.defaults;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.session.SqlSession;
import site.sanniu.mybatis.session.SqlSessionFactory;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
