package com.drlee.unit10_innerclass.test3;

import com.drlee.unit10_innerclass.test1.Contents;
import com.drlee.unit10_innerclass.test1.Destination;

public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;

        public int value() {
            return i;
        }
    }

    // 静态内部类可以包含所有静态的东西和非静态的东西,但是静态内部类中不能访问外围类中的非静态的东西。
    protected static class ParcelDestination implements Destination{
        private String label;

        private ParcelDestination(String whereTo)
        {

            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
        public static void f(){}

        public void ff(){};

        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s)
    {
        return new ParcelDestination(s);
    }
    public static Contents conetnes()
    {
        return new ParcelContents();
    }
}
