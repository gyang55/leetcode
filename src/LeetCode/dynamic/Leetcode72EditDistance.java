package LeetCode.dynamic;

public class Leetcode72EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // If word2 is empty
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        //If word1 is empty
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        //Iterate word1 and word2
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[n][m];
    }
}
