package site.sanniu.mybatis.transaction.jdbc;

import site.sanniu.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class JdbcTransaction implements Transaction {
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }
}
