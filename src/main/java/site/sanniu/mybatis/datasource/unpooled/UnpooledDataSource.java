package site.sanniu.mybatis.datasource.unpooled;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class UnpooledDataSource implements DataSource {

    private ClassLoader driverClassLoader;

    /**
     * 驱动
     */
    private String driver;

    private String url;

    private String username;

    private String password;

    /**
     * 是否自动提交
     */
    private Boolean autoCommit;

    /**
     * 事务级别
     */
    private Integer defaultTransactionIsolationLevel;

    /**
     * 驱动注册器
     */
    private static Map<String, Driver> registeredDrivers = new ConcurrentHashMap<>();

    /**
     * 驱动配置，也可以扩展属性信息 driver
     */
    private Properties driverProperties;

    static {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while(drivers.hasMoreElements()){
            Driver driver = drivers.nextElement();
            registeredDrivers.put(driver.getClass().getName(),driver);
        }
    }

    /**
     * 静态代理类
     */
    private static class DriverProxy implements Driver {

        private Driver driver;

        public DriverProxy(Driver driver) {
            this.driver = driver;
        }

        @Override
        public Connection connect(String url, Properties info) throws SQLException {
            return this.driver.connect(url,info);
        }

        @Override
        public boolean acceptsURL(String url) throws SQLException {
            return this.driver.acceptsURL(url);
        }

        @Override
        public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
            return this.driver.getPropertyInfo(url,info);
        }

        @Override
        public int getMajorVersion() {
            return this.driver.getMajorVersion();
        }

        @Override
        public int getMinorVersion() {
            return this.driver.getMinorVersion();
        }

        @Override
        public boolean jdbcCompliant() {
            return this.driver.jdbcCompliant();
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return this.driver.getParentLogger();
        }
    }

    private synchronized void initializerDriver(){
        if(!registeredDrivers.containsKey(driver)){
            try{
                Class<?> driverType = Class.forName(driver, true, driverClassLoader);
                Driver driverNewInstance = (Driver)driverType.newInstance();
                DriverManager.registerDriver(new DriverProxy(driverNewInstance));
                registeredDrivers.put(driver,driverNewInstance);
            }catch (Exception e){

            }
        }
    }

    private Connection doGetConnection(String username,String password) throws SQLException {
        Properties props = new Properties();
        if(driverProperties != null){
            props.putAll(driverProperties);
        }

        if(username != null){
            props.setProperty("user",username);
        }

        if(password != null){
            props.setProperty("password",password);
        }

        return doGetConnection(props);
    }

    private Connection doGetConnection(Properties properties) throws SQLException {
        initializerDriver();
        Connection connection = DriverManager.getConnection(url, properties);

        if(connection != null && connection.getAutoCommit() != autoCommit){
            connection.setAutoCommit(autoCommit);
        }

        if(defaultTransactionIsolationLevel != null){
            connection.setTransactionIsolation(defaultTransactionIsolationLevel);
        }
        return connection;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return doGetConnection(username,password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return doGetConnection(username,password);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return (T) new SQLException(getClass().getName() + "is not a wrapper.");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return DriverManager.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        DriverManager.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        DriverManager.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public ClassLoader getDriverClassLoader() {
        return driverClassLoader;
    }

    public void setDriverClassLoader(ClassLoader driverClassLoader) {
        this.driverClassLoader = driverClassLoader;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Integer getDefaultTransactionIsolationLevel() {
        return defaultTransactionIsolationLevel;
    }

    public void setDefaultTransactionIsolationLevel(Integer defaultTransactionIsolationLevel) {
        this.defaultTransactionIsolationLevel = defaultTransactionIsolationLevel;
    }

    public static Map<String, Driver> getRegisteredDrivers() {
        return registeredDrivers;
    }

    public static void setRegisteredDrivers(Map<String, Driver> registeredDrivers) {
        UnpooledDataSource.registeredDrivers = registeredDrivers;
    }

    public Properties getDriverProperties() {
        return driverProperties;
    }

    public void setDriverProperties(Properties driverProperties) {
        this.driverProperties = driverProperties;
    }
}
