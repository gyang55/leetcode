package search;

import java.util.Arrays;

public class LeetCode1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n;
        while (l <= r) {
            int x = (l + r) >> 1;
            int idx = binarySearch(nums, x); // nums中第一个大于等于x的元素位置
            if (x == n - idx) {
                return x;
            } else if (x < n - idx) { // 大于等于x的元素太多了，所以下一轮搜索要增大x的取值范围
                l = x + 1;
            } else { // 反之，减少x的取值范围
                r = x - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int val = nums[mid];
            if (val >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}



