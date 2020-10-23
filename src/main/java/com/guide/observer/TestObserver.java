package com.guide.observer;

public class TestObserver {
    public static void main(String[] args) {
        ProductObservable product = new ProductObservable();
        product.addObserver(new NameObserver());//增加观察者
        product.addObserver(new PriceObserver());//增加观察者
        product.setName("露露");//改变name
        product.setPrice(10000);//改变价格
    }
}
