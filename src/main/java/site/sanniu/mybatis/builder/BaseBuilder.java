package site.sanniu.mybatis.builder;

import site.sanniu.mybatis.session.Configuration;
import site.sanniu.mybatis.type.TypeAliasRegistry;
import site.sanniu.mybatis.type.TypeHandlerRegistry;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public abstract class BaseBuilder {

    protected Configuration configuration;

    protected TypeAliasRegistry typeAliasRegistry;

    protected TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }

}
