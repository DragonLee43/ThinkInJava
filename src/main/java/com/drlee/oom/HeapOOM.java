package com.drlee.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DrLee
 * @Date 2021/7/12 14:47
 */
public class HeapOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        // java 这个词在之前就出现过了， 不符合intern()方法 要求“首次遇到”的原则
        System.out.println(str2.intern() == str2);

    }
}
