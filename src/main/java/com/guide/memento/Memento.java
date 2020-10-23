package com.guide.memento;

import lombok.Data;

//备忘录角色 存储系统的内部状态
@Data
public class Memento {
    private String state;
    public  Memento(String state){
        this.state = state;
    }
}
