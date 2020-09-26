package com.xgen.util.readxml;

import lombok.Data;
import lombok.Getter;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Data
public class ElementsExpression extends ReadXmlExpression{
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

    public ElementsExpression(String eleName, String condition) {
        this.eleName = eleName;
        this.condition = condition;
    }

    public void addEle(ReadXmlExpression readXmlExpression){
        this.eles.add(readXmlExpression);
    }
    public String[] interpret(Context context) {
        //1.维护父级节点记录
        List<Element> pEles = context.getPreEles();
        //获取当前元素，多个
        ArrayList<Element> nowEles = new ArrayList<Element>();
        for (Element pEle : pEles) {
            nowEles.addAll(context.getNowEles(pEle,eleName));
        }
        //判断条件
        Iterator<Element> it = nowEles.iterator();
        while (it.hasNext()){
            Element ele = it.next();
            if(!context.judgeCondition(ele,condition)){
                it.remove();
            }
        }
        //设置父节点
        context.setPreEles(nowEles);
        //2：循环解释子元素
        String ss[] = null;
        for (ReadXmlExpression tempele : eles) {
            ss = tempele.interpret(context);
        }
        return ss;
    }
    @Override
    public Object clone(){
        ElementsExpression obj = null;
        try{
            obj = (ElementsExpression)super.clone();
            List<ReadXmlExpression> objEles = new ArrayList<ReadXmlExpression>();
            for (ReadXmlExpression re : eles) {
                objEles.add((ReadXmlExpression)re.clone());
            }
            obj.setEles(objEles);
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
