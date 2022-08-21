package site.sanniu.mybatis.scripting.xmltags;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class StaticTextSqlNode implements SqlNode{

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }


}
