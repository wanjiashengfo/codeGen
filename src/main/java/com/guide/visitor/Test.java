package com.guide.visitor;

public class Test {
    public static void main(String[] args) {
        Visitor ceo = new CEO();
        Visitor a = new A();
        Visitor b = new B();

        Visitable pa = new PartA();
        Visitable pb = new PartB();

        ObjectStructure os = new ObjectStructure();
        os.addVisitor(pa);
        os.addVisitor(pb);
        os.accept(ceo);
        os.accept(a);
        os.accept(b);
    }
}
