package site.sanniu.mybatis.scripting.xmltags;

/**
 * SQL 节点
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public interface SqlNode {
    boolean apply(DynamicContext context);
}
