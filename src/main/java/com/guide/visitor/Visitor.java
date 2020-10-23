package com.guide.visitor;
//访问者 放入所有可能的访问类型
public interface Visitor {
    public void visit(PartA a);
    public void visit(PartB b);
}
