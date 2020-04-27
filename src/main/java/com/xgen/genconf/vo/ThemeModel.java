package com.xgen.genconf.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ThemeModel {
    private String id;
    private String location;
    private Map<String,GenTypeModel> mapGenTypes = new HashMap<String, GenTypeModel>();
    private Map<String,String> mapProviders = new HashMap<String, String>();
}
