package com.xgen.util.readxml;

import lombok.Data;

@Data
public class ParseModel {
    /**
     * 元素的名称
     */
    private String eleName;
    /**
     * 是属性还是元素值
     */
    private boolean propertyValue;
    /**
     * 是否终结符
     */
    private boolean end;
    /**
     * 是否单个值
     */
    private boolean singleValue;
    /**
     * 条件表达式
     */
    private String condition;
}
