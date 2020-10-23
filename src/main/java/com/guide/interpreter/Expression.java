package com.guide.interpreter;
//抽象表达式角色 也可以用接口来实现
public abstract class Expression {
    public abstract int interpret(ContextOfInterpreter con);
}
