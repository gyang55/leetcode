package LeetCode.arrays;

import java.util.HashMap;

public class Leetcode1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] notFound = {-1, -1};
        if (nums.length < 2) {

            return notFound;
        }
        HashMap<Integer, Integer> storeNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (storeNums.get(difference) == null) {
                storeNums.put(nums[i], i);
            } else {
                int[] result = {i, storeNums.get(difference)};
                return result;
            }

        }
        return notFound;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        Leetcode1TwoSum leetcode1TwoSum = new Leetcode1TwoSum();
        int[] res = leetcode1TwoSum.twoSum(nums, 6);
        System.out.println(res[0] + " " + res[1]);
    }
}
