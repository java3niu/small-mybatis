package site.sanniu.mybatis.reflection.wrapper;

import site.sanniu.mybatis.reflection.MetaObject;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface ObjectWrapperFactory {
    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
