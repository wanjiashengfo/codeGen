package com.guide.command;
//关机命令
public class CommandOff implements Command{
    private TV myTV;
    public CommandOff(TV myTV){
        this.myTV = myTV;
    }
    @Override
    public void execute() {
        myTV.turnOff();
    }
}
