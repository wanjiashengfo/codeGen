package com.guide.mediator;
//生产者
public class Producer extends Thread{
    private Mediator med;
    private int id;
    private static int num = 1;
    public Producer(Mediator m){
        med = m;
        id = num++;
    }
    public void run(){
        int times = 0;
        while (times<5){
            times++;
           med.storeMessage(num=(int)(Math.random()*100));
            System.out.println("生产者" + id + "-" + num + "");
        }
    }
}
