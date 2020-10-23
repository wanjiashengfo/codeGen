package com.guide.flyweight;

import java.util.ArrayList;
import java.util.List;

public class TestFlyweight {
    //客户下的订单
    private static List<Order> orders = new ArrayList<>();
    //订单对象生成工厂
    private static FlavorFactory flavorFactory;
    //增加订单
    private static void takeOrders(String flavor){
        orders.add(flavorFactory.getOrder(flavor));
    }
    public static void main(String[] args) {
        //订单生成工厂
        flavorFactory = FlavorFactory.getInstance();
        //增加订单
        takeOrders("摩卡");
        takeOrders("卡布奇诺");
        takeOrders("香草星冰乐");
        takeOrders("香草星冰乐");
        takeOrders("拿铁");
        takeOrders("卡布奇诺");

        //卖咖啡
        for (Order order : orders) {
            order.sell();
        }
        //打印生成的java对象数量
        System.out.println("共生成了" + flavorFactory.getTotalFlavorsMade() + "个flavor java对象");
    }
}
