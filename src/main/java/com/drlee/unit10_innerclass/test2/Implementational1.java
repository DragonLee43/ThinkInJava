package com.drlee.unit10_innerclass.test2;

import sun.security.smartcardio.SunPCSC;

// 具体服务实现类
public class Implementational1 implements Service{

    private Implementational1(){};
    public void method1() {
        System.out.println("Implementational1 method1 invoke.");
    }

    public void method2() {
        System.out.println("Implementational1 method2 invoke.");
    }

    // 返回一个专门构造Implementational1对象的工厂
    public static ServiceFactory factory(){
        return new ServiceFactory() {
            public Service getService() {
                return new Implementational1();
            }
        };
    }
}

class Implementational2 implements Service{

    private Implementational2(){}
    public void method1() {
        System.out.println("Implementational2 method1 invoke.");
    }

    public void method2() {
        System.out.println("Implementational2 method1 invoke.");
    }

    public static ServiceFactory factory()
    {
        return new ServiceFactory(){
            public Service getService() {
                return new Implementational2();
            }
        };
    }
}
