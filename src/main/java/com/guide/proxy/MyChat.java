package com.guide.proxy;
//具体角色类 被代理的类
public class MyChat implements Chat{
    @Override
    public void reply(String message) {
        System.out.println("let me anwser....");
    }
}
