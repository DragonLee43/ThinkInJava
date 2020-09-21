package com.drlee.unit10_innerclass.test1;

/**
 * 练习2 ：内部类可以访问外围类的所有成员属性
 * 当外围类对象创建内部类的对象时，会秘密捕获它的外围类对象的引用。然后，当你访问外围类的成员时，
 * 就是这个引用来选择外围类的成员。
 */
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size)
    {
        items = new Object[size];
    }

    public void add(Object x)
    {
        if (next < items.length)
        {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements  Selector
    {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i< items.length)
                i++;
        }
    }

    public Selector selector()
    {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end())
        {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
