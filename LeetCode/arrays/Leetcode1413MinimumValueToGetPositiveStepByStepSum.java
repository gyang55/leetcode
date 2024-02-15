package LeetCode.arrays;

import java.util.Arrays;

public class Leetcode1413MinimumValueToGetPositiveStepByStepSum {
    class Solution {
        public int minStartValue(int[] nums) {
            int ans = 0, sum = 0;
            for (int num : nums) {
                if (ans > (sum += num)) ans = sum;
            }
            return 1 - ans;
        }
    }
}
