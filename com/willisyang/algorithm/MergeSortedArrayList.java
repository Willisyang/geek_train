package com.willisyang.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FilterDuplicateData {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            Solution.merge(nums1, m, nums2, n);
            String out = integerArrayToString(nums1);

            System.out.print(out);
        }
    }

    public static class Solution {
        // [1,2,3,0,0,0]
        // 3
        // [2,5,6]
        // 3
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            if(nums1 == null||nums2==null){
                return;
            }
            //1.将所有nums2元素添加到nums1中的后面；
            int start=0;
            for (int i=m;i<m+n;++i) {
                nums1[i] = nums2[start];
                start++;
            }
            //2.对nums1重新排序；
            int swapTemp;
            for(int i=0;i<m+n;++i){
                for(int j=i+1;j<m+n;++j){
                    if(nums1[j]<nums1[i]){
                        swapTemp = nums1[i];
                        nums1[i]=nums1[j];
                        nums1[j] = swapTemp;
                    }
                }
            }
            //官方参考：
            //  System.arraycopy(nums2, 0, nums1, m, n);
            //  Arrays.sort(nums1);
        }

    }
}