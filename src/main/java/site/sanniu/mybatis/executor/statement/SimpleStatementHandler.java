package site.sanniu.mybatis.executor.statement;

import site.sanniu.mybatis.executor.Executor;
import site.sanniu.mybatis.executor.resultset.ResultSetHandler;
import site.sanniu.mybatis.mapping.BoundSql;
import site.sanniu.mybatis.mapping.MappedStatement;
import sun.plugin2.main.server.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class SimpleStatementHandler extends BaseStatementHandler{

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultSetHandler resultSetHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultSetHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }


}
