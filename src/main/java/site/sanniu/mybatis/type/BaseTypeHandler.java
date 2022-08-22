package site.sanniu.mybatis.type;

import site.sanniu.mybatis.session.Configuration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 类型处理器的基类
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public abstract class BaseTypeHandler<T> implements TypeHandler<T>{

    protected Configuration configuration;

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        // 定义抽象方法，由子类实现不同类型的属性设置
        setNonNullParameter(ps, i, parameter, jdbcType);
    }

    protected abstract void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;


}