package com.xgen.genconf.vo;

import lombok.Data;

@Data
public class ExtendConfModel {
    private String id;
    private String value;
    private String[] values;
    private boolean single;
}
