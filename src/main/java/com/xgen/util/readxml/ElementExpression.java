package com.xgen.util.readxml;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class ElementExpression extends ReadXmlExpression{
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

    public ElementExpression(String eleName, String condition) {
        this.eleName = eleName;
        this.condition = condition;
    }

    public void addEle(ReadXmlExpression readXmlExpression){
        this.eles.add(readXmlExpression);
    }
    public boolean removeEle(ReadXmlExpression readXmlExpression){
        this.eles.remove(readXmlExpression);
        return true;
    }

    public void removeAllEles(){
        this.eles.clear();
    }
    public String[] interpret(Context context) {
        //1.维护父级节点记录

        //1.1先取出父节点的元素
        List<Element> pEles = context.getPreEles();
        Element ele = null;

        List<Element> nowEles = new ArrayList<Element>();
        if(pEles==null||pEles.size()==0) {
            //1.2判断父节点是否存在，如果不存在表示是根元素
            ele = context.getDocument().getDocumentElement();
            pEles.add(ele);
            context.setPreEles(pEles);
        }else {
            //1.3如果存在就应该找到当前表达式所对应的元素，把这个元素设置成父节点
            for (Element pEle : pEles) {
                nowEles.addAll(context.getNowEles(pEle,eleName));
                if(nowEles.size()>0){
                    break;
                }
            }
            if(nowEles.size()>0&&context.judgeCondition(nowEles.get(0),condition)){
                List<Element> tempList = new ArrayList<Element>();
                tempList.add(nowEles.get(0));
                context.setPreEles(tempList);
            }
        }
        //2：循环解释子元素
        String ss[] = null;
        for (ReadXmlExpression tempele : eles) {
            ss = tempele.interpret(context);
        }
        return ss;
    }
}
