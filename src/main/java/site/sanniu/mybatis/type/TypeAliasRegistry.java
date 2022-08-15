package site.sanniu.mybatis.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class TypeAliasRegistry {

    private final Map<String,Class<?>> TYPE_ALIASES = new HashMap<>();

    public TypeAliasRegistry() {
        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    public void registerAlias(String alis,Class<?> value){
        String key = alis.toLowerCase(Locale.ENGLISH);
        TYPE_ALIASES.put(key,value);
    }

    public <T> Class<T> resolveAlias(String type){
        String key = type.toLowerCase(Locale.ENGLISH);
        return (Class<T>)TYPE_ALIASES.get(key);
    }

}
