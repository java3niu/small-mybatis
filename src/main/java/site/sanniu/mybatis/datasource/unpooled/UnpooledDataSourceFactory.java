package site.sanniu.mybatis.datasource.unpooled;

import site.sanniu.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setDriver(properties.getProperty("driver"));
        unpooledDataSource.setUrl(properties.getProperty("url"));
        unpooledDataSource.setPassword(properties.getProperty("password"));
        return unpooledDataSource;
    }
}
