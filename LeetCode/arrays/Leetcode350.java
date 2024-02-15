package LeetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int n : nums1
        ) {
            int count = countMap.getOrDefault(n, 0) + 1;
            countMap.put(n, count);
        }
        int index = 0;
        for (int n : nums2
        ) {
            int count = countMap.getOrDefault(n, 0);
            if (count > 0) {
                res[index++] = n;
                count--;
                if (count > 0) {
                    countMap.put(n, count);
                } else {
                    countMap.remove(n);

                }
            }
        }
        for (int n : res
        ) {
            System.out.print(n + " ");
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = new Leetcode350().intersect(nums1, nums2);
        for (int n : res
        ) {
            System.out.print(n + " ");
        }
    }

}
