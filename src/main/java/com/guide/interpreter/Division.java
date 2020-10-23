package com.guide.interpreter;
//非终结符表达式角色
public class Division extends Expression{
    private Expression left,right;
    public Division(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(ContextOfInterpreter con) {
        try{
            return left.interpret(con)/right.interpret(con);
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1111;
    }
}
