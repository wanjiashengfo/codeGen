package com.guide.command;
//开机命令
public class CommandOn implements Command{
    private TV myTV;
    public CommandOn( TV myTV){
        this.myTV = myTV;
    }
    @Override
    public void execute() {
        myTV.turnOn();
    }
}
