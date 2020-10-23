package com.guide.visitor;
//人事部门管理者 访问者的具体实现
public class B implements Visitor{
    @Override
    public void visit(PartA a) {

    }

    @Override
    public void visit(PartB b) {
        System.out.println("人事部门主管管理"+b.getName());
    }
}
