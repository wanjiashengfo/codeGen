package com.guide.proxy;
//代理类 持有被代理类的一个引用
public class ChatProxy implements Chat{
    private MyChat mc = new MyChat();
    @Override
    public void reply(String message) {
        System.out.println(message);
        if(message.equals("Hello")){
            System.out.println("Hi");
        }else if(message.equals("How do you do")){
            System.out.println("How do you do");
        }else {
            mc.reply(message);
        }
    }
}
