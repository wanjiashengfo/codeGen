package com.xgen.util.readxml;

import org.w3c.dom.Element;

import java.util.List;

public class PropertiesTerminalExpression extends  ReadXmlExpression{
    /**
     * 属性名字
     */
    private String propName;

    public PropertiesTerminalExpression(String propName) {
        this.propName = propName;
    }

    public String[] interpret(Context context) {
        //获取父元素
        List<Element> pEles = context.getPreEles();
        //直接取钙元素的属性
        String[] ss = new String [pEles.size()];
        for (int i = 0;i < ss.length ; i++) {
            ss[i] = pEles.get(i).getAttribute(propName);
        }

        return ss;
    }
    @Override
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();

        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
