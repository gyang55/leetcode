package search;

public class Leetcode153FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            //if low==high, the search should be ended
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else {
                    low = pivot + 1;
                }
            }
            return nums[low];
        }
    }

}
