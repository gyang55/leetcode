package LeetCode.arrays;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode658FindKClosestElements {
    /**
     * 排序
     */
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> nums = new ArrayList<>();
//        for (int n : arr
//        ) {
//            nums.add(n);
//        }
//
//        Collections.sort(nums, (a, b) -> {
//            if (Math.abs(a - x) != Math.abs(b - x)) {
//                return Math.abs(a - x) - Math.abs(b - x);
//            } else {
//                return a - b;
//            }
//        });
//
//        List<Integer> ans = nums.subList(0, k);
//        Collections.sort(ans);
//        return ans;
//    }

    /**
     * 二分法，直到x或者第一个比x大的数，分为左右两部分，left=right-1.right>=x
     * 如果x-left<=right-x, 取左边的数，left--，反之取右边的数，right++。
     * 分界点的数是closest to x的数，所以从分界点开始找k个数
     * */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int right = binarySearch(arr, x);
            int left = right - 1;
            while (k-- > 0) {
                if (left < 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else if (x - arr[left] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            }
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = left + 1; i < right; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        public int binarySearch(int[] arr, int x) {
            int low = 0, high = arr.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }


}
