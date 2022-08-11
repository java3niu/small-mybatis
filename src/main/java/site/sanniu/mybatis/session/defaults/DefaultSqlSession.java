package site.sanniu.mybatis.session.defaults;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.session.SqlSession;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return null;
    }
}
