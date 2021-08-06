package com.drlee.proxy;

/**
 * @Author: DrLee
 * @Date 2021/8/6 17:00
 */
public class User {
    public static void main(String[] args) {
        Worker worker = new Seller();
        worker.sell();
        System.out.println("-----------------");

        Worker proxy = new ScalperProxy(new Seller());
        proxy.sell();
    }
}
