package site.sanniu.mybatis.executor;

import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.MappedStatement;
import site.sanniu.mybatis.session.ResultHandler;
import site.sanniu.mybatis.session.RowBounds;
import site.sanniu.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * 语句执行器
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);


}
