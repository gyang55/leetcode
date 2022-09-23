package LeetCode.arrays;

public class JZ53 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */
//    class Solution {
//        public int search(int[] nums, int target) {
//            int count = 0;
//            for (int n : nums
//            ) {
//                if (n == target) {
//                    count++;
//                }
//            }
//            return count;
//        }
//    }
//    class Solution {
//        public int search(int[] nums, int target) {
//            return helper(nums, target) - helper(nums, target - 1);
//        }
//        int helper(int[] nums, int tar) {
//            int i = 0, j = nums.length - 1;
//            while(i <= j) {
//                int m = (i + j) / 2;
//                if(nums[m] <= tar) i = m + 1;
//                else j = m - 1;
//            }
//            return i;
//        }
//    }
//}

    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}