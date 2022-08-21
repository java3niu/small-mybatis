package site.sanniu.mybatis.reflection.invoker;

/**
 * 调用者
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();
}
