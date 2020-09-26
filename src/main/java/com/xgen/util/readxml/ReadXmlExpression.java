package com.xgen.util.readxml;

public abstract class ReadXmlExpression implements Cloneable{
    public abstract String[] interpret(Context context);
    @Override
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
