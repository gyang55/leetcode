package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missings = new ArrayList<>();
        int n = nums.length;
        for (int num : nums
        ) {
            int index = (num - 1) % n; // return the original index of the LeetCode.number because some LeetCode.number might have been changed
            nums[index] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                missings.add(i+1);
            }
        }
        return missings;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Leetcode448FindAllNumbersDisappearedInAnArray leetcode448FindAllNumbersDisappearedInAnArray = new Leetcode448FindAllNumbersDisappearedInAnArray();
        List<Integer> disappearedNumbers = leetcode448FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        for (int num : disappearedNumbers
        ) {
            System.out.print(num + " ");
        }
    }
}
