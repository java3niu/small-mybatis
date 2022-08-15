package site.sanniu.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
