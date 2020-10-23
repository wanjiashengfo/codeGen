package com.guide.flyweight;

import java.util.HashMap;
import java.util.Map;

//不同口味的订单工厂类，该类是享元模式的关键 确保每种口味的订单只生成一次 用来生成可共享的每种口味的咖啡订单
public class FlavorFactory {
    private Map<String,Order> flavorPool = new HashMap<String,Order>();
    //静态工厂 负责生成订单对象
    private static FlavorFactory flavorFactory = new FlavorFactory();
    private FlavorFactory(){}
    public static FlavorFactory getInstance(){
        return flavorFactory;
    }
    //此方法是享元模式的关键
    public Order getOrder(String flavor){
        Order order = null;
        if(flavorPool.containsKey(flavor)){
            //如果此映射包含指定键的映射关系 则返回对应口味的订单对象
            order = flavorPool.get(flavor);
        }else {
            order = new FlavorOrder(flavor);
            flavorPool.put(flavor,order);
        }
        return order;
    }
    public int getTotalFlavorsMade(){
        return flavorPool.size();
    }
}
