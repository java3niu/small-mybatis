package site.sanniu.mybatis.test;

import site.sanniu.mybatis.binding.MapperProxyFactory;
import site.sanniu.mybatis.io.Resources;
import site.sanniu.mybatis.session.SqlSession;
import site.sanniu.mybatis.session.SqlSessionFactory;
import site.sanniu.mybatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class Test {

    public static void main(String[] args) {

        String resource = "mybatis-datasource-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        mapper.getUesrById(1L);
    }

    public static void main1(String[] args) {


    }

}
