package site.sanniu.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 结果集处理器
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement) throws SQLException;

}
