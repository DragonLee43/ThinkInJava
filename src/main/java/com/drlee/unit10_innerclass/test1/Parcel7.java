package com.drlee.unit10_innerclass.test1;

/**
 * 匿名内部类，创建一个继承自Contents匿名类的对象，
 */
public class Parcel7 {
    public Contents contents(){
        return new Contents() {
            private int i = 11;
            public int value() {
                return i;
            }
        };
    }
}
