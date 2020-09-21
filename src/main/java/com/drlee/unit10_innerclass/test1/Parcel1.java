package com.drlee.unit10_innerclass.test1;

import sun.security.krb5.internal.crypto.Des;

import java.sql.SQLOutput;

/**
 * 第一个内部类
 * Parcel：包
 * 内部类特点： 可以访问它的外围类的所有成员。
 */
public class Parcel1
{
    class Contents
    {
        private int i = 11;
        public int value()
        {
            return i;
        }
    }

    class Destination{
        private String label;

        public Destination(String whereTo)
        {
            label = whereTo;
        }
        String readLabel()
        {
            return label;
        }
    }

    public Contents contents()
    {
        return new Contents();
    }
    public Destination to(String dest)
    {
        return new Destination(dest);
    }

    public void ship(String dest)
    {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
}
