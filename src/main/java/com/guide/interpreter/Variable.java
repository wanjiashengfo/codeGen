package com.guide.interpreter;

public class Variable extends Expression {

    @Override
    public int interpret(ContextOfInterpreter con) {
        //this为调用interpret方法的visiable对象
        return con.LookupValue(this);
    }
}
