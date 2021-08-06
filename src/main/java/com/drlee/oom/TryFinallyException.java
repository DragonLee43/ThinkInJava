package com.drlee.oom;

import com.drlee.unit7.Test;

/**
 * @Author: DrLee
 * @Date 2021/7/14 16:30
 */
public class TryFinallyException {

    public static void main(String[] args) {
        System.out.println(new TryFinallyException().test());
    }

    public int test() {
        int x = 0;
        try {
            x = 1;
            int i =0;
            i = x/i;
            return x;
        } catch (Exception e) {
            x = 3;
            return x;
        } finally {
            x =2;
        }
    }
}
