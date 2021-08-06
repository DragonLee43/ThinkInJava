package com.drlee.oom;

/**
 * @Author: DrLee
 * @Date 2021/7/14 16:12
 */
public class ClassFileStructure {

    public void printOut(int[] ages, String name) {
        for (int age : ages) {
            System.out.println(age);
        }
        System.out.println(name);
    }

    public static void main(String[] args) {
        new ClassFileStructure().printOut(new int[] {1,2,3}, "HelloWorld!");
    }
}
