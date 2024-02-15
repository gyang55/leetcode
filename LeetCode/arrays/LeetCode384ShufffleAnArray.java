package LeetCode.arrays;

import java.util.Random;

public class LeetCode384ShufffleAnArray {
    class Solution {
        int[] nums;
        int n;

        public Solution(int[] nums) {
            this.nums = nums;
            n = nums.length;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] ans = nums.clone();
            for (int i = 0; i < n - 1; i++) {
                swap(ans, i, i + random.nextInt(n - i));
            }
            return ans;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
