package com.xgen.output.types;

import com.xgen.output.GenOutputEbi;

import java.util.Observable;

public class OutputToConsole implements GenOutputEbi {
    @Override
    public void update(Observable o, Object obj) {
        String content =""+obj;
        System.out.println("now content = "+content);
    }
}
