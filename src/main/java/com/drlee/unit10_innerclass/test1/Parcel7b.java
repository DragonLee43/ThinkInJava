package com.drlee.unit10_innerclass.test1;

public class Parcel7b {
    public Contents contents(){
        return new MyContents();
    };

    class MyContents implements Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }
}
