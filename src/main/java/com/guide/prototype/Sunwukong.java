package com.guide.prototype;

import lombok.Data;

@Data
public class Sunwukong implements Cloneable{
    //身高
    private int height;
    //体重
    private int weight;
    //年龄
    private int age;

    public Sunwukong(int height, int weight,int age){
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public Object clone(){
        Sunwukong temp = new Sunwukong(height, weight, age);
        return (Object)temp;
    }
}
