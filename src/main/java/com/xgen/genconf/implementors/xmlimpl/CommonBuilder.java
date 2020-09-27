package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.constants.GenConfEnum;

public abstract class CommonBuilder<T> {
    //用来获取分步骤拼接的字符串 也就是最终产品
    public abstract StringBuffer getBuilderBuffer() ;
    //  获取实际的构建器对象
    protected abstract T getBuilderClassInstance();
    //支持连缀,拼接“.”
    public T addDot(){
        getBuilderBuffer().append(ExpressionEnum.dot.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“/”
    public T addSeparator(){
        getBuilderBuffer().append(ExpressionEnum.separator.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“$”
    public T addDollar(){
        getBuilderBuffer().append(ExpressionEnum.dollar.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“[”
    public T addOpenBracket(){
        getBuilderBuffer().append(ExpressionEnum.openBracket.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“]”
    public T addCloseBracket(){
        getBuilderBuffer().append(ExpressionEnum.closeBracket.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“=”
    public T addEqual(){
        getBuilderBuffer().append(ExpressionEnum.equal.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“,”
    public T addComma(){
        getBuilderBuffer().append(ExpressionEnum.comma.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“,”
    public T addXml(){
        getBuilderBuffer().append(ExpressionEnum.xml.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“,”
    public T addXmlFilePre(){
        getBuilderBuffer().append(ExpressionEnum.xmlFilePre.getExpr());
        return getBuilderClassInstance();
    }
    //支持连缀,拼接“id”
    public T addId(){
        getBuilderBuffer().append(GenConfEnum.id);
        return getBuilderClassInstance();
    }
    public T addOtherValue(String value){
        getBuilderBuffer().append(value);
        return getBuilderClassInstance();
    }

    public String build(){
        return getBuilderBuffer().toString();
    }
}
