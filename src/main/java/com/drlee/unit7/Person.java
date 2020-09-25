package com.drlee.unit7;

public class Person {
    private String name;
    public Person(String name)
    {
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name + "正在吃饭");
    }

    private final void set()
    {

    }
}

class aa extends  Person
{

    public aa(String name) {
        super(name);
    }
    private final void set()
    {

    }
}
