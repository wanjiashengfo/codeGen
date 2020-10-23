package com.guide.command;
//命令接收者
public class TV {
    public int currentChannel = 0;
    public void turnOn(){
        System.out.println("the TV is on");
    }
    public void turnOff(){
        System.out.println("the TV is off");
    }
    public void changeChannel(int channel){
        this.currentChannel = channel;
        System.out.println("Now TV channel is " + channel);
    }
}
