package site.sanniu.mybatis.executor.result;

import site.sanniu.mybatis.session.ResultContext;

/**
 * @Author sanniu
 * @Description 默认结果上下文
 * @Date $ $
 **/
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }


}
