package com.guide.command;

public class TestCommand {
    public static void main(String[] args) {
        //命令接收者
        TV tv = new TV();
        //开机命令
        CommandOn commandOn = new CommandOn(tv);
        //关机命令
        CommandOff commandOff = new CommandOff(tv);
        //切换频道命令
        CommandChange commandChange = new CommandChange(tv,2);

        //命令控制对象
        Control control = new Control(commandOn, commandOff, commandChange);

        control.turnOn();
        control.changeChannel();
        control.turnOff();
    }
}
