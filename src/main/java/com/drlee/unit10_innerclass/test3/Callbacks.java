package com.drlee.unit10_innerclass.test3;

/**
 * 10.8.1 闭包与回调
 */
interface Incrementable{
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("other operation");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}
// 被调用类
class Callee2 extends MyIncrement{
    private int i =0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements  Incrementable{
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackPerference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh){
        callbackReference = cbh;
    }
    void go(){
        callbackReference.increment();
    }

}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackPerference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
