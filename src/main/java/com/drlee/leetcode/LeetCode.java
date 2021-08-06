package com.drlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {

    // 1,2,3,9   9,9,9,9 ,8,9,9
    public int[] plusOne(int[] digits) {

        int addNumber = 1;
        int currentNumber = digits[digits.length - 1] + addNumber;
        int currentIndex = digits.length - 1;
        while (currentNumber / 10 >= 1 && currentIndex > 0)
        {
            digits[currentIndex] = currentNumber % 10;
            currentNumber /= 10;
            // 上一位相加以后的值
            currentNumber += digits[--currentIndex];
        }

        if (currentNumber / 10 >=1)  // 10, 11, 12
        {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            result[1] = 0;

            if (digits.length > 1){
                System.arraycopy(digits,1, result, 2, digits.length -1);
            }
            return result;
        }else {
            digits[currentIndex] = currentNumber;
            return digits;
        }
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     */

    // Object src,  int  srcPos,
    //                                        Object dest, int destPos,
    //                                        int length
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
    }

    /**
     * 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 1){
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(1);
            result.add(list1);
            return result;
        }
        if (numRows == 2){
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();
            list1.add(1);
            list2.add(1);
            list2.add(1);
            result.add(list1);
            result.add(list2);
            return result;
        }
        List<List<Integer>> generate = generate(numRows - 1);

        List<Integer> integers = generate.get(generate.size() - 1);
        List<Integer> last = new ArrayList<Integer>(integers.size() + 1);

        last.add(1);
        for (int i = 1; i < integers.size(); i++) {
            last.add(integers.get(i - 1) + integers.get(i));
        }
        last.add(1);
        generate.add(last);
        return generate;
    }
}
