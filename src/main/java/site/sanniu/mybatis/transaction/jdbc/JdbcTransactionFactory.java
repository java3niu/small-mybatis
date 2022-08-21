package site.sanniu.mybatis.transaction.jdbc;

import site.sanniu.mybatis.session.TransactionIsolationLevel;
import site.sanniu.mybatis.transaction.Transaction;
import site.sanniu.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
