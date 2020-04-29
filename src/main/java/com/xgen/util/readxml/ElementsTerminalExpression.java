package com.xgen.util.readxml;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElementsTerminalExpression extends ReadXmlExpression{
    /**
     * 用来记录组合的子readxmlexpression元素
     */
    private List<ReadXmlExpression> eles = new ArrayList<ReadXmlExpression>();
    /**
     * 元素的名称
     */
    private String eleName = "";
    /**
     * 判断的条件
     */
    private String condition = "";

    public ElementsTerminalExpression(String eleName, String condition) {
        this.eleName = eleName;
        this.condition = condition;
    }

    public String[] interpret(Context context) {
        //1.获取到自己这多个元素
        List<Element> pEles = context.getPreEles();
        //获取当前元素，多个
        List<Element> nowEles  = new ArrayList<Element>();

        for (Element pEle : pEles) {
            nowEles.addAll(context.getNowEles(pEle,eleName));
        }
        //2.判断这些元素是否满足条件
        Iterator<Element> it = nowEles.iterator();
        while (it.hasNext()){
            Element ele = it.next();
            if(!context.judgeCondition(ele,condition)){
                it.remove();
            }
        }
        //3.获取这些元素的值
        String [] ss = new String[nowEles.size()];
        for (int i = 0; i < ss.length; i++) {
            Element ele = nowEles.get(i);
            if(ele.getFirstChild()!=null){
                ss[i] = ele.getFirstChild().getNodeValue();
            }else {
                ss[i] = "";
            }
        }
        return ss;
    }
}
