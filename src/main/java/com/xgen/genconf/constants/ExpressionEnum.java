package com.xgen.genconf.constants;

import lombok.Getter;

public enum ExpressionEnum {
    dot("."),separator("/"),dollar("$"),openBracket("["),closeBracket("]"),
    equal("="),comma(","),xml("xml"),xmlFilePre("xgenconfxml/"),
    themeXmlName("ThemeConf.xml"),location("Location"),propBeginStr("${"),
    propEndStr("}"),methodBeginStr("$["),methodEndStr("]"),template("template");
    @Getter
    private String expr;

    private ExpressionEnum(String expr){
        this.expr = expr;
    }
}
