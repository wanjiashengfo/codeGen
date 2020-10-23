package com.guide.flyweight;
//不同口味的订单
public class FlavorOrder extends Order{
    private String flavor;
    //设置咖啡口味
    public FlavorOrder(String flavor){
        this.flavor = flavor;
    }
    @Override
    public void sell() {
        System.out.println("卖出一份" + flavor + "的咖啡");
    }
}
