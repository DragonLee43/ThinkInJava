package com.drlee.proxy;

/**
 * @Author: DrLee
 * @Date 2021/8/6 16:57
 */
public class ScalperProxy implements Worker{

    private Worker worker;

    @Override
    public void sell() {
        worker.sell();
        this.noQueue();
    }

    public  ScalperProxy(Worker worker) {
        this.worker = worker;
    }

    public void noQueue() {
        System.out.println("不用排队哦！！！");
    }
}
