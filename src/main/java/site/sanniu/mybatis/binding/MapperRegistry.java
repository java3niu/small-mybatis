package site.sanniu.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import site.sanniu.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class MapperRegistry {

    /**
     * 将 已添加的映射器代理加入到 缓存中
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 获取 class 对应的 映射器代理对象
     * @param type
     * @param sqlSession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){

        return null;
    }

    /**
     * 添加映射器代理工厂对象
     * @param type
     * @param <T>
     */
    public <T> void addMapper(Class<T> type){
        if(type.isInterface()){

        }
    }

    /**
     * 缓存中是否存在 该class 对应的映射器代理工厂对象
     * @param type
     * @param <T>
     * @return
     */
    public <T> boolean hasMapper(Class<T> type){

        return true;
    }

    /**
     * 扫描对应路径 获取对应路径上的class，并将其添加到缓存中
     * @param packageName
     */
    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }



}
