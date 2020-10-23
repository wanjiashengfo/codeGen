package com.guide.mediator;

public class Mediator {
    private int number;
    private boolean slotFull = false;
    public synchronized void storeMessage(int num){
        while (slotFull)
            try{
                wait();
            }catch(Exception e){
                e.printStackTrace();
            }
            slotFull = true;
            number = num;
            notifyAll();

    }
    public synchronized int retrieveMessage(){
        while (!slotFull)
            try{
                wait();
            }catch(Exception e){
                e.printStackTrace();
            }
            slotFull = false;

            notifyAll();
            return number;

    }
}
