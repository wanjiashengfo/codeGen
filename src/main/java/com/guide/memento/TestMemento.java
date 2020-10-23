package com.guide.memento;

public class TestMemento {
    public static void main(String[] args) {
        WindowsSystem windowsSystem = new WindowsSystem();
        User user = new User();//某用户
        windowsSystem.setState("好的状态");//系统处于好的运行状态
        user.saveMemento(windowsSystem.createMemento());//用户对系统进行备份 系统要产生备份文件
        windowsSystem.setState("坏的状态");//系统处于不好的运行状态
        System.out.println("当前系统处于" + windowsSystem.getState());
        windowsSystem.restoreMemento(user.retrieveMemento());//系统进行恢复 用户发恢复命令
        System.out.println("当前系统处于" + windowsSystem.getState());
    }
}
