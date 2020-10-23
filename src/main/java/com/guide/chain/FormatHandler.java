package com.guide.chain;
//具体处理者角色
public class FormatHandler extends Handler{
    @Override
    public void handleRequest(String request) {
        if(request.equals("format")){
            System.out.println("Now begin format!");
        }else {
            //传递到下一个
            successor.handleRequest(request);
        }
    }
}
