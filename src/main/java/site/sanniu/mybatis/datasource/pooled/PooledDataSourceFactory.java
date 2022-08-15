package site.sanniu.mybatis.datasource.pooled;

import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSource;
import site.sanniu.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    @Override
    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(properties.getProperty("driver"));
        pooledDataSource.setUrl(properties.getProperty("url"));
        pooledDataSource.setPassword(properties.getProperty("password"));
        return pooledDataSource;
    }

}
