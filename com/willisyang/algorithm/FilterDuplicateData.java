package com.willisyang.algorithm;

public class FilterDuplicateData {
    public static void main(String[] nums) {
        System.out.println("hello");
        
        int[] test = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int len = removeDuplicates(test);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(test[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        // if(nums.length <= 0){
        // return 0;
        // }
        // int lastDuplicateData = 0;
        // int len = nums.length;
        // int i = 1;
        // int temp = 0;
        // for (; i < nums.length; ++i) {
        // if (lastDuplicateData == nums[i]) {
        // if (i + 1 < nums.length) {
        // temp = nums[i];
        // nums[i] = nums[i + 1];
        // nums[i+1] = temp;
        // }
        // --len;
        // } else {
        // lastDuplicateData = nums[i];
        // }
        // }

        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;       
    }
}