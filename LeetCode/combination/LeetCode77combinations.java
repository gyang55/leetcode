package LeetCode.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77combinations {
    public List<List<Integer>> combine(int n, int k) {
        // result
        List<List<Integer>> result = new ArrayList<>();
        //Save iterate paths
        LinkedList<Integer> temp = new LinkedList<>();
        backtracking(1, result, temp, n, k);
        return result;
    }

    private void backtracking(int start, List<List<Integer>> result, LinkedList<Integer> temp, int n, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtracking(i + 1, result, temp, n, k);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        LeetCode77combinations leetCode77combinations = new LeetCode77combinations();
        System.out.println(leetCode77combinations.combine(n, k));
    }
}
