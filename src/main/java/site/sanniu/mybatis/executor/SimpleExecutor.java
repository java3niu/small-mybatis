package site.sanniu.mybatis.executor;

import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.transaction.Transaction;
import sun.plugin2.main.server.ResultHandler;

import java.util.List;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class SimpleExecutor extends BaseExecutor{

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        Configuration configuration = ms.getConfiguration();
        return null;
    }
}
