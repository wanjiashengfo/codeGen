package com.guide.strategy;

public class Context {
    private Strategy stg;
    public Context(Strategy theStg){
        this.stg = theStg;
    }
    public void DoAction(){
        this.stg.AlgrithmInterface();
    }
}
