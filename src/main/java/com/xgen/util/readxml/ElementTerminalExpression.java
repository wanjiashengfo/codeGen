package com.xgen.util.readxml;

import org.w3c.dom.Element;

import java.util.List;

public class ElementTerminalExpression extends ReadXmlExpression{
    /**
     * 元素的名称
     */
    private String eleName = "";
    /**
     * 判断的条件
     */
    private String condition = "";

    public ElementTerminalExpression(String eleName, String condition) {
        this.eleName = eleName;
        this.condition = condition;
    }

    public String[] interpret(Context context) {
        //1.获取到自己这个元素
        //1.1先获取到父元素
        List<Element> pEles = context.getPreEles();
        //1.2根据父元素和自己元素的名字，查找到自己这个元素
        Element ele = null;

        if(pEles.size() == 0){
            //说明是根元素
           ele = context.getDocument().getDocumentElement();
        }else {
            ele= context.getNowEles(pEles.get(0),eleName).get(0);
        }
        //2.判断这个元素是否满足条件
        if(!context.judgeCondition(ele,condition)){
            return new String[0];
        }

        //3.获取这个元素的值

        String[] ss = new String[1];
        if(ele.getFirstChild()!=null){
            ss[0] = ele.getFirstChild().getNodeValue();
        }else {
            ss[0] = "";
        }
        return ss;
    }
}
