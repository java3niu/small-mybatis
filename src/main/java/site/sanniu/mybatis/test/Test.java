package site.sanniu.mybatis.test;

import site.sanniu.mybatis.binding.MapperProxyFactory;

import java.util.HashMap;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class Test {

    public static void main(String[] args) {
        MapperProxyFactory<IUserMapper> mapperProxyFactory = new MapperProxyFactory<>(IUserMapper.class);
        IUserMapper iUserMapper = mapperProxyFactory.newInstance(new HashMap<String, String>());
        iUserMapper.getUesrName();


    }

}
