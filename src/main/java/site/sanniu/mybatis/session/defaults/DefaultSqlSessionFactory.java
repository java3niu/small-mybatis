package site.sanniu.mybatis.session.defaults;

import site.sanniu.mybatis.binding.MapperRegistry;
import site.sanniu.mybatis.executor.Executor;
import site.sanniu.mybatis.mapping.Environment;
import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.session.SqlSession;
import site.sanniu.mybatis.session.SqlSessionFactory;
import site.sanniu.mybatis.session.TransactionIsolationLevel;
import site.sanniu.mybatis.transaction.Transaction;
import site.sanniu.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }

    }
}
