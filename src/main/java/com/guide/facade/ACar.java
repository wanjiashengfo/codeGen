package com.guide.facade;
//赛车类 定义了赛车的各种动作
public class ACar {
    public void start(){
        System.out.println("车子已启动");
    }
    public void check_stop(){
        System.out.println("刹车检查");
    }
    public void check_box(){
        System.out.println("油箱检查");
    }
    public void check_console(){
        System.out.println("仪表盘检查");
    }
}
