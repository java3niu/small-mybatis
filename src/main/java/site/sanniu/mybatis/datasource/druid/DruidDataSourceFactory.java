package site.sanniu.mybatis.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import site.sanniu.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties   = properties;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setUsername(properties.getProperty("username"));
        return dataSource;
    }
}
