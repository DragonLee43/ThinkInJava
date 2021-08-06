package com.drlee.proxy;


/**
 * @Author: DrLee
 * @Date 2021/8/6 16:56
 */
public class Seller implements Worker {
    @Override
    public void sell() {
        System.out.println("卖票");
    }
}
