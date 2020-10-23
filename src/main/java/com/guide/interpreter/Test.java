package com.guide.interpreter;

public class Test {
    private static Expression ex;
    private static ContextOfInterpreter con;
    public static void main(String[] args) {
        con = new ContextOfInterpreter();
        //设置变量 常量
        Variable a = new Variable();
        Variable b = new Variable();
        Constant c = new Constant(2);
        //为变量赋值
        con.addValue(a,6);
        con.addValue(b,7);
        //运算 对橘子的结构由我们自己来分析 构造
        ex = new Division(new Multiply(a,b),new Add(new Subtract(a,b),c));
        System.out.println("运算结果为：" + ex.interpret(con));
    }
}
