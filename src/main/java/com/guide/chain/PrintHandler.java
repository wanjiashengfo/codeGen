package com.guide.chain;
//具体处理者角色
public class PrintHandler extends Handler{
    @Override
    public void handleRequest(String request) {
        if(request.equals("print")){
            System.out.println("Now begin print!");
        }else {
            //传递到下一个
            successor.handleRequest(request);
        }
    }
}
