package com.xgen.genconf.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class GenTypeModel {
    private String id;
    private String genTypeClass;
    private Map<String,String> mapParams = new HashMap<String,String>();

}
