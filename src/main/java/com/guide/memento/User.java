package com.guide.memento;
//备忘录管理者Caretaker角色 负责保存好备忘录 不能对备忘录的内容进行操作或检查
public class User {
    private Memento memento;
    public Memento retrieveMemento(){
        //恢复系统
        return this.memento;
    }
    public void saveMemento(Memento memento){
        //保存系统
        this.memento = memento;
    }
}
