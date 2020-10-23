package com.guide.interpreter;

public class Constant extends Expression{
    private int i;
    public Constant(int i){
        this.i = i;
    }
    @Override
    public int interpret(ContextOfInterpreter con) {
        return i;
    }
}
