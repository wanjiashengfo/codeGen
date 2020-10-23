package com.guide.mediator;
//消费者
public class Consumer extends Thread{
    private Mediator med;
    private int id;
    private static int num = 1;
    public Consumer(Mediator m){
        med = m;
        id = num++;
    }
    public void run(){
        int times = 0;
        while (times<5){
            times++;
            System.out.println("消费者" + id + "-" + med.retrieveMessage() + "");
        }
    }
}
