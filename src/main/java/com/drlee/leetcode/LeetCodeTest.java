package com.drlee.leetcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LeetCodeTest {

    LeetCode leetCode = new LeetCode();

    @Test
    public void testPlusOne(){
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] trues = {9,8,7,6,5,4,3,2,1,1};
        int[] results = leetCode.plusOne(digits);
        Assert.assertArrayEquals(results,trues);
    }

    @Test
    public void testMerge(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        leetCode.merge(nums1,3,nums2,3);
    }

    @Test
    public void testGernate(){
        List<List<Integer>> generate = leetCode.generate(5);
        for (List<Integer> integers: generate) {
            for (Integer i : integers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
