package com.guide.visitor;
//财务部门 具体的被访问结点
public class PartA implements Visitable{
    String s = "财务部门";
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public String getName(){
        return s;
    }
}
