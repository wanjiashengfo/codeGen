package com.xgen.util.readxml;


import org.w3c.dom.Element;

public class PropertyTerminalExpression extends ReadXmlExpression{
    private String propName;

    public PropertyTerminalExpression(String propName) {
        this.propName = propName;
    }

    public String[] interpret(Context context) {
        String[] ss = new String[1];
        //1.获取父元素
        Element pEle = context.getPreEles().get(0);
        //2.直接取该元素的属性的值
        ss[0] = pEle.getAttribute(propName);
        return  ss;
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
