package ru.alexandradeeva.homework_week7;

import java.util.Arrays;

class Task1Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4, 0, 0, 0, 0, 0};
        int[] result = removeDuplicates(nums);

        System.out.println(Arrays.equals(result, expectedNums));
    }

    public static int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[length] = nums[i];
                length++;
            }
        }
        for (int i = length; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}



