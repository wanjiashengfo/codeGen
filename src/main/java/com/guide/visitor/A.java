package com.guide.visitor;
//财务部门管理者 访问者的具体实现
public class A implements Visitor{
    @Override
    public void visit(PartA a) {
        System.out.println("财务部门主管管理"+a.getName());
    }

    @Override
    public void visit(PartB b) {

    }
}
