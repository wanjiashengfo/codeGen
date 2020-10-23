package com.guide.command;
//遥控器 将各种命令封装到一个类中
public class Control {
    private Command onCommand,offCommand,changeChannel;
    public Control(Command onCommand,Command offCommand,Command changeChannel){
        this.changeChannel = changeChannel;
        this.offCommand = offCommand;
        this.onCommand = onCommand;
    }

    public void turnOn(){
        onCommand.execute();
    }
    public void turnOff(){
        offCommand.execute();
    }
    public void changeChannel(){
        changeChannel.execute();
    }
}
