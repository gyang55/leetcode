package LeetCode.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47Permutation2 {
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            used[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        new Leetcode47Permutation2().permuteUnique(nums);
    }
}
