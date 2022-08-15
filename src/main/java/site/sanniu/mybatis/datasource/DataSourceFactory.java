package site.sanniu.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface DataSourceFactory {

    void setProperties(Properties properties);

    DataSource getDataSource();

}
