package site.sanniu.mybatis.session;

/**
 * 结果上下文
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();


}
