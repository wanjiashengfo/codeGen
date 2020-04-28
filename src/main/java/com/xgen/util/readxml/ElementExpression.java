package com.xgen.util.readxml;

import java.util.ArrayList;
import java.util.List;

public class ElementExpression extends ReadXmlExpression{

    private List<ReadXmlExpression> eles = new ArrayList<ReadXmlExpression>();
    public String[] interpret(Context context) {
        return new String[0];
    }
}
