package LeetCode.duoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15sum3 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length < 3) {
//            return res;
//        }
//
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            //跳过相同的第一个数
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int third = nums.length - 1;
//            int target = -nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//                while (j < third && nums[j] + nums[third] > target) {
//                    third--;
//                }
//                if (j == third) {
//                    break;
//                }
//
//                if (nums[j] + nums[third] == target) {
//                    List<Integer> sum = new ArrayList<>();
//                    sum.add(nums[i]);
//                    sum.add(nums[j]);
//                    sum.add(nums[third]);
//                    res.add(sum);
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip same number
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    while (l < r && nums[l] == nums[l+1]) ++l ;
                    while (l < r && nums[r] == nums[r-1]) --r ;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }

            }

        }
        return ans;
    }
}
