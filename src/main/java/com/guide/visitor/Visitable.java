package com.guide.visitor;
//被访问结点 通过accept操作 让每个访问结点具备可访问性
public interface Visitable {
    public void accept(Visitor v);
}
