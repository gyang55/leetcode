package LeetCode.backtracking.permutation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, path, ans, target);
        return ans;
    }

    private void dfs(int[] candidates, int startIndex, Deque<Integer> path, List<List<Integer>> ans, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, path, ans, target - candidates[i]);

            // 状态重置
            path.removeLast();
        }
    }
}
