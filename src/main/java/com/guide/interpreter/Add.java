package com.guide.interpreter;
//非终结符表达式角色
public class Add extends Expression{
    private Expression left,right;
    public  Add(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(ContextOfInterpreter con) {
        return left.interpret(con)+right.interpret(con);
    }
}
