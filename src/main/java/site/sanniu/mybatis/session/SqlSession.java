package site.sanniu.mybatis.session;

import site.sanniu.mybatis.binding.MapperProxyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface SqlSession {

    /**
     *
     * @param statement
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement);

    /**
     * @param statement
     * @param parameter
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement,Object parameter);

    /**
     * @param type
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> type);

}
