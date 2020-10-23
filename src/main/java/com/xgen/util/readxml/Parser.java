package com.xgen.util.readxml;

import lombok.Data;

import java.util.*;

public class Parser {
    private static final String FORWAR_SLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    /**
     * 按照分解的先后顺序的元素所对应的路径
     */
    private static List<String> listElePath = null;

    private Parser() {
    }
    //////////////////备忘录部分-begin//////////////////
    @Data
    private static class MementoImpl implements ParseMemento{
        private Map<String,ReadXmlExpression> mapRe = new HashMap<String, ReadXmlExpression>();

        public MementoImpl(Map<String, ReadXmlExpression> mapRe) {
            this.mapRe = mapRe;
        }

    }
    public static ReadXmlExpression parse(String expr){
//        System.out.println("=======使用备忘录=======");
        ReadXmlExpression retObj = null;
        //1.应该获取备忘录对象
        ParseMemento memento = ParseCaretaker.getInstance().retriveMemnto();

        //2.从备忘录中取出数据
        Map<String,ReadXmlExpression> mapRe = null;
        if(memento == null){
            mapRe = new HashMap<String, ReadXmlExpression>();
        }else {
            mapRe = ((MementoImpl) memento).getMapRe();
        }
        //3.从缓存里面找出最长的相同的string来，这部分就不用解析了
        String notParseExpr = searchMaxLongEquals(expr,mapRe);

        //4.得到剩下的需要解析的部分
        String needParseExpr = "";
        if(notParseExpr.trim().length() == 0){
            needParseExpr = expr;
        }else{
            if(notParseExpr.length() < expr.length()){
                needParseExpr = expr.substring(notParseExpr.length()+1);
            }else{
                needParseExpr = "";
            }
        }
        //5.真正解析剩下的需要解析的string把两个部分抽象语法树合并起来
        if(needParseExpr.trim().length()>0){
            retObj = parse2(needParseExpr,notParseExpr,mapRe);
        }else {
            retObj = mapRe.get(notParseExpr);
        }
        //6.解析完了重新设置备忘录
        ParseCaretaker.getInstance().saveMemento(new MementoImpl(mapRe));
        return retObj;
    }

    /**
     * 最长的已经解析过的字符串
     * @param expr
     * @param mapRe
     * @return
     */
    private static String searchMaxLongEquals(String expr,Map<String,ReadXmlExpression> mapRe){
        boolean flag = mapRe.containsKey(expr);
        while (!flag){
            int lastIndex = expr.lastIndexOf(FORWAR_SLASH);
            if(lastIndex > 0){
                expr = expr.substring(0,lastIndex);
                flag = mapRe.containsKey(expr+FORWAR_SLASH);
            }else {
                expr = "";
                flag = true;
            }
        }
        return expr;
    }
    /////////////////备忘录部分-end/////////////////////
    /**
     * 根据传入的表达式，通过解析，组合成为一个抽象的语法树
     * @param
     * @return 表达式对应的抽象语法树
     */
    private static ReadXmlExpression parse2(String needParseExpr,String notParseExpr,Map<String,ReadXmlExpression> mapRe){
        listElePath = new ArrayList<String>();
        //1.分解表达式，得到需要解析的元素名称和该元素对应的解析模型
        Map<String, ParseModel> mapPath = parseMapPath(needParseExpr);
        //2根据元素对应的解析模型 转换成相应的解释器对象
        Map<String,ReadXmlExpression> mapPathAndRe = mapPath2Expression(mapPath);
        //3按照先后顺序组成成为抽象语法树
        ReadXmlExpression prefixRe = mapRe.get(notParseExpr+FORWAR_SLASH);
        //为了使用的过程中，不会对备忘录的数据造成影响，所以才克隆一份过去用
        if(prefixRe!=null){
            prefixRe = (ReadXmlExpression)mapRe.get(notParseExpr+FORWAR_SLASH).clone();
        }
        ReadXmlExpression retTree  = buildTree(notParseExpr,prefixRe,mapPathAndRe,mapRe);

        return retTree;
    }

    /**
     * 按照从左到右的顺序来解析表达式 得到相应的元素路径和该元素对应的解析模型
     * @param expr
     * @return
     */
    private static Map<String,ParseModel> parseMapPath(String expr){
        Map<String,ParseModel> mapPath = new HashMap<String, ParseModel>();

        StringBuffer pathBuffer = new StringBuffer();
        //root/a/b/c.name
        StringTokenizer tokenizer = new StringTokenizer(expr,FORWAR_SLASH);
        while (tokenizer.hasMoreTokens()){
            String onePath = tokenizer.nextToken();
            if(tokenizer.hasMoreTokens()){
                //还有下一个，说明不是结尾
                pathBuffer.append(onePath+FORWAR_SLASH);
                setParsePath(pathBuffer,onePath,false, false,mapPath);
            }else {
                //说明到结尾了
                int dotIndex = onePath.indexOf(DOT);
                if(dotIndex > 0){
                    //属性结尾
                    String eleName = onePath.substring(0,dotIndex);
                    String propName = onePath.substring(dotIndex+1);
                    //设置路径
                    pathBuffer.append(eleName+DOT);
                    //设置属性前面的元素
                    setParsePath(pathBuffer,eleName,false,false,mapPath);
                    pathBuffer.append(propName);
                    //设置属性
                    setParsePath(pathBuffer,propName,true,true,mapPath);
                }else {
                    //元素结尾
                    pathBuffer.append(onePath);
                    setParsePath(pathBuffer,onePath,true ,false, mapPath);
                }
                //已经解析到结尾，退出
                break;
            }
        }
        return mapPath;
    }

    private static void setParsePath(StringBuffer buffer,String eleName, boolean end,boolean propertyValue, Map<String, ParseModel> mapPath) {

        ParseModel pm = new ParseModel();
        pm.setEnd(end);
        pm.setPropertyValue(propertyValue);
        pm.setSingleValue(!(eleName.indexOf(DOLLAR) > 0));
        //去掉$
        eleName = eleName.replace(DOLLAR,"");

        int tempBegin = 0;
        int tempEnd = 0;

        if((tempBegin = eleName.indexOf(OPEN_BRACKET))>0){
            tempEnd = eleName.indexOf(CLOSE_BRACKET);
            pm.setCondition(eleName.substring(tempBegin+1,tempEnd));
            eleName = eleName.substring(0,tempBegin);
        }
            pm.setEleName(eleName);


        mapPath.put(buffer.toString(), pm);
        listElePath.add(buffer.toString());
    }

    /**
     * 根据元素对应的解析模型 转换成相应的解释器对象
     * @param mapPath
     * @return
     */
    private static Map<String,ReadXmlExpression> mapPath2Expression(Map<String,ParseModel> mapPath){
        //一定要按照分解的先后顺序来转换成相应的解释器对象
        Map<String,ReadXmlExpression> map = new HashMap<String,ReadXmlExpression>();
        for (String key : listElePath) {
            ParseModel pm = mapPath.get(key);
            ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);
            map.put(key,obj);
        }
        return map;
    }

    private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm){
        ReadXmlExpression obj = null;
        if(!pm.isEnd()){
            if(pm.isSingleValue()){
                obj = new ElementExpression(pm.getEleName(),pm.getCondition());
            }else {
                obj = new ElementsExpression(pm.getEleName(),pm.getCondition());
            }
        }else {
            if(pm.isPropertyValue()){
                if(pm.isSingleValue()){
                    obj = new PropertyTerminalExpression(pm.getEleName());
                }else {
                    obj = new PropertiesTerminalExpression(pm.getEleName());
                }
            }else {
                if(pm.isSingleValue()){
                    obj = new ElementTerminalExpression(pm.getEleName(),pm.getCondition());
                }else {
                    obj = new ElementsTerminalExpression(pm.getEleName(),pm.getCondition());
                }
            }
        }
        return obj;
    }

    /**
     * 按照先后顺序组成成为抽象语法树
     * @param
     * @return
     */
    private static ReadXmlExpression buildTree(String prefixStr,ReadXmlExpression prefixRe, Map<String,ReadXmlExpression > mapPathAndRe,Map<String,ReadXmlExpression> mapRe){
        //第一个对象，根对象，也就是返回去的对象
        ReadXmlExpression retRe = prefixRe;
        //用来临时记录一个元素，也就是父元素
        ReadXmlExpression preRe = getLastRE(prefixRe);

        for (String path : listElePath) {
            ReadXmlExpression re = mapPathAndRe.get(path);
            if(preRe == null){
                preRe = re;
                retRe = re;
            }else {
                //吧当前元素添加到父元素下面 同时把自己设置成父元素
                if(preRe instanceof  ElementExpression){
                    ElementExpression ele = (ElementExpression) preRe;
                    ele.addEle(re);
                    preRe = re;
                }else if(preRe instanceof  ElementsExpression){
                    ElementsExpression eles = (ElementsExpression) preRe;
                    eles.addEle(re);
                    preRe = re;
                }
            }
            //每次生成一个新的抽象树对象，就应该添加到缓存里面,应该把retRe克隆一份（原型模式）
            if(prefixStr!=null&&prefixStr.trim().length()>0){
                mapRe.put(prefixStr+FORWAR_SLASH+path,(ReadXmlExpression)retRe.clone());
            }else {
                mapRe.put(path,(ReadXmlExpression)retRe.clone());
            }
        }
        return retRe;
    }

    /**
     * 获取已经解析过得对象树的最后一个元素对象
     * @param prefixRe
     * @return
     */
    private static ReadXmlExpression getLastRE(ReadXmlExpression prefixRe){
        ReadXmlExpression lastRe = prefixRe;
        boolean flag = true;
        while (flag){
            if(lastRe instanceof ElementExpression){
                if(((ElementExpression)lastRe).getEles().size()>0){
                    //替换成子元素，然后用循环实现递归
                    lastRe = ((ElementExpression) lastRe).getEles().get(0);
                    if(lastRe instanceof ElementExpression){
                        flag = ((ElementExpression)lastRe).getEles().size()>0;
                    }else if(lastRe instanceof ElementsExpression){
                        flag = ((ElementsExpression)lastRe).getEles().size()>0;
                    }else {
                        flag = false;
                    }
                }else {
                    flag = false;
                }
            }else if(lastRe instanceof ElementsExpression){
                if(((ElementsExpression)lastRe).getEles().size()>0){
                    lastRe = ((ElementsExpression) lastRe).getEles().get(0);
                    if(lastRe instanceof ElementExpression){
                        flag = ((ElementExpression)lastRe).getEles().size()>0;
                    }else if(lastRe instanceof ElementsExpression){
                        flag = ((ElementsExpression)lastRe).getEles().size()>0;
                    }else {
                        flag = false;
                    }
                }else {
                    flag = false;
                }
            }else {
                flag = false;
            }
        }
        return lastRe;
    }
}
