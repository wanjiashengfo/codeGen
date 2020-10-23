package com.guide.command;
//频道切换命令
public class CommandChange implements Command{
    private TV myTV;
    private int channel;
    public CommandChange(TV myTV,int channel){
        this.myTV = myTV;
        this.channel = channel;
    }
    @Override
    public void execute() {
        myTV.changeChannel(channel);
    }
}
