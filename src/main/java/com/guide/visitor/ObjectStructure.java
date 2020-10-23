package com.guide.visitor;

import java.util.ArrayList;
import java.util.List;

//提供一个高层接口以允许该访问者访问它的元素
public class ObjectStructure {
    public List<Visitable> eumn = new ArrayList<>();
    public void addVisitor(Visitable e){
        eumn.add(e);
    }
    public void removeVisitor(Visitable e){
        eumn.remove(e);
    }
    public void accept(Visitor v){
        for (Visitable e : eumn) {
            e.accept(v);
        }
    }
}
