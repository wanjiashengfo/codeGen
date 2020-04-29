package com.xgen.util.readxml;

import lombok.Data;
import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上下文，存放解释器需要的一些全局信息
 */
@Data
public class Context {
    private Document document = null;
    /**
     * 上次被处理的多个父节点的元素集合
     */
    private List<Element> preEles = new ArrayList<Element>();
    /**
     * 用来缓存多个context实例
     */
    private static Map<String,Context> mapCtx = new HashMap<String,Context>();

    public static Context getInstance(String filePathName) throws Exception {
        Context c = mapCtx.get(filePathName);
        if(c==null){
            Document document = XmlUtil.getDocument(filePathName);
            c = new Context(document);
            mapCtx.put(filePathName,c);
        }
        //先初始化一下
        c.init();
        return c;
    }

    private void init(){
        preEles = new ArrayList<Element>();
    }
    private Context(Document document) {
        this.document = document;
    }

    public List<Element> getNowEles(Element pEle,String eleName){
        List<Element> nowEles = new ArrayList<Element>();
        NodeList tempList = pEle.getChildNodes();
        for (int i = 0; i < tempList.getLength(); i++) {
            if(tempList.item(i) instanceof Element){
                Element ele = (Element) tempList.item(i);
                if(ele.getTagName().equals(eleName)){
                    nowEles.add(ele);
                }
            }
        }
        return nowEles;
    }

    /**
     * 目前只是实现了判断元素的属性等于某个条件的情况
     * @param ele
     * @param condition
     * @return
     */
    public boolean judgeCondition(Element ele,String condition){
        if(condition==null||condition.trim().length()==0){
            return true;
        }
        String ss[] = condition.split("=");
        if(ss[1]!=null&&ss[1].equals(ele.getAttribute(ss[0]))){
            return true;
        }
        return false;

    }

}
