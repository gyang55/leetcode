package LeetCode.monotonicStack;

import java.util.Stack;

class Leetcode1856MaximumSubarrayMinProduct {
    public static int maxSumMinProduct(int[] n) {
        Stack<Integer> st = new Stack<>();
        long dp[] = new long[n.length + 1], res = 0;
        for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];
        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int)(res % 1000000007);
    }

    public static void main(String[] args){
        int[] nums ={1,2,3,2};

        System.out.println(maxSumMinProduct(nums));
    }
}
