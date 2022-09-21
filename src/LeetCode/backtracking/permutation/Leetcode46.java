package LeetCode.backtracking.permutation;

import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, new LinkedList<Integer>(), visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                curr.add(nums[i]);
                dfs(nums, res, curr, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args){
        int[] arr = {1,2,3};
        Leetcode46 leetcode46 = new Leetcode46();
        System.out.println(leetcode46.permute(arr));
    }
}
