package com.drlee.unit10_innerclass.test2;

public class Factorys {
    // 工厂消费
    public static void serviceConsumer(ServiceFactory fact)
    {
        Service service = fact.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        Factorys.serviceConsumer(Implementational1.factory());
        Factorys.serviceConsumer(Implementational2.factory());
    }
}
