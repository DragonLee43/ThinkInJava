package com.drlee.unit10_innerclass.test2;

public class Parcel4 {
    private class PContents implements Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;
        private PDestination(String whereTo)
        {
            label = whereTo;
        }
        public String readLabel()
        {
            return label;
        }
    }

    public PDestination destination(String s)
    {
        return new PDestination(s);
    }

    public Contents contents()
    {
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();

        Contents c = p.contents();
        PDestination d = p.destination("hello");

    }
}
