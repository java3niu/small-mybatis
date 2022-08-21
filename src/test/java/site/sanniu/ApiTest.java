package site.sanniu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.sanniu.dao.IUserDao;
import site.sanniu.mybatis.io.Resources;
import site.sanniu.mybatis.session.SqlSession;
import site.sanniu.mybatis.session.SqlSessionFactory;
import site.sanniu.mybatis.session.SqlSessionFactoryBuilder;
import site.sanniu.po.User;

import java.io.IOException;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        //logger.info("测试结果：{}", JSON.toJSONString(user));
    }


}
