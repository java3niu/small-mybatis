package site.sanniu.mybatis.builder;

import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.type.TypeAliasRegistry;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public abstract class BaseBuilder {

    protected Configuration configuration;

    protected TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
