package site.sanniu.mybatis.reflection.wrapper;

import site.sanniu.mybatis.reflection.MetaObject;
import site.sanniu.mybatis.reflection.factory.ObjectFactory;
import site.sanniu.mybatis.reflection.property.PropertyTokenizer;

import java.util.List;

public interface ObjectWrapper {

    // get
    Object get(PropertyTokenizer prop);

    // set
    void set(PropertyTokenizer prop, Object value);

    // 查找属性
    String findProperty(String name, boolean useCamelCaseMapping);

    // 取得getter的名字列表
    String[] getGetterNames();

    // 取得setter的名字列表
    String[] getSetterNames();

    //取得setter的类型
    Class<?> getSetterType(String name);

    // 取得getter的类型
    Class<?> getGetterType(String name);

    // 是否有指定的setter
    boolean hasSetter(String name);

    // 是否有指定的getter
    boolean hasGetter(String name);

    // 实例化属性
    MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

    // 是否是集合
    boolean isCollection();

    // 添加属性
    void add(Object element);

    // 添加属性
    <E> void addAll(List<E> element);


}
