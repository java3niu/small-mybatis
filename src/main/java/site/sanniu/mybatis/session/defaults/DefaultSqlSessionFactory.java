package site.sanniu.mybatis.session.defaults;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.session.SqlSession;
import site.sanniu.mybatis.session.SqlSessionFactory;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
