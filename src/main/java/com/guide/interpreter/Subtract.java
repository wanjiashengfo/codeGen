package com.guide.interpreter;
//非终结符表达式角色
public class Subtract extends Expression{
    private Expression left,right;
    public Subtract(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(ContextOfInterpreter con) {
        return left.interpret(con)-right.interpret(con);
    }
}
