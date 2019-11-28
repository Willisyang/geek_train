package com.willisyang.algorithm;

public class RoteArray {
    public static void main(String[] args) {
        int[] test = { -1, -100, 3, 99 };
        rotate(test, 2);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    // 输入: [1,2,3,4,5,6,7] 和 k = 3
    // 输出: [5,6,7,1,2,3,4]
    // 解释:
    // 向右旋转 1 步: [7,1,2,3,4,5,6]
    // 向右旋转 2 步: [6,7,1,2,3,4,5]
    // 向右旋转 3 步: [5,6,7,1,2,3,4]

    // 输入: [-1,-100,3,99] 和 k = 2
    // 输出: [3,99,-1,-100]
    // 解释:
    // 向右旋转 1 步: [99,-1,-100,3]
    // 向右旋转 2 步: [3,99,-1,-100]
    public static void rotate(int[] nums, int k) {
        if (nums.length < 1) {
            return;
        }
        if (k < 1) {
            return;
        }
        int end = k % nums.length;
        int temp = nums[nums.length - 1];
        for (int i = 0; i < end; ++i) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; --j) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}