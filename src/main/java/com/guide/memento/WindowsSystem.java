package com.guide.memento;

import lombok.Data;

//备忘发起originator角色 创建备忘录 和恢复备忘录
@Data
public class WindowsSystem {
    private String state;
    public Memento createMemento(){
        //创建系统备份
        return new Memento(state);
    }
    public void restoreMemento(Memento m ){
        //恢复系统
        this.state = m.getState();
    }
}
