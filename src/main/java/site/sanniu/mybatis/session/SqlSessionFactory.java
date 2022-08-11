package site.sanniu.mybatis.session;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return
     */
    SqlSession openSession();

}
