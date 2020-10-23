package com.guide.builder;

import lombok.Data;

@Data
public class Part {
    private String partName;
    public Part( String partName){
        this.partName = partName;
    }
}
