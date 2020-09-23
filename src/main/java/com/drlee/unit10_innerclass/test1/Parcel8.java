package com.drlee.unit10_innerclass.test1;

public class Parcel8 {
    public Wrapping wrapping(int x)
    {
        return new Wrapping(x){
            public int value(){
                return super.value() *10;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p8 = new Parcel8();
        Wrapping wrapping = p8.wrapping(10);
        System.out.println(wrapping.value());
    }
}
