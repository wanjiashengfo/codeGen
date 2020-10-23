package com.guide.chain;

import lombok.Data;

//抽象处理者角色
@Data
public abstract class Handler {
    protected Handler successor;
    public abstract void handleRequest(String request);

}
