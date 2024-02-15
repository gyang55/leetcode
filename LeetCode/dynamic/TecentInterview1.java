package LeetCode.dynamic;

public class TecentInterview1 {
    /**
     * int n n个位置
     * int s 开始位置
     * int e 结束位置
     * int k 机器人必须走k步
     * 问：走k步，从s走到e，有多少种方法
     * 机器人可以随意往左走或者往右走只能走一步
     */

    /**
     * 不用动态规划的时间复杂度为高度为K的二叉树，所以为2^k
     */
    public static int walkWays1(int n, int e, int s, int k) {
        return find1(n, e, k, s);
    }

    public static int find1(int n, int e, int rest, int cur) {
        if (rest == 0) {
            return cur == e ? 1 : 0;
        }

        //来到第一个位置，只能去2
        if (cur == 1) {
            return find1(n, e, rest - 1, 2);
        }

        //来到最后一个位置，只能去n-1
        if (cur == n) {
            return find1(n, e, rest - 1, n - 1);
        }

        //中间位置，可以往左或者往右
        return find1(n, e, rest - 1, cur - 1) + find1(n, e, rest - 1, cur + 1);
    }

    public static int walkWays(int n, int e, int s, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return find2(n, e, k, s, dp);
    }

    /**
     * 动态规划O（1）这个方法是计划搜索
     */
    public static int find2(int n, int e, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == e ? 1 : 0;
            return dp[rest][cur];
        }

        //来到第一个位置，只能去2
        if (cur == 1) {
            dp[rest][cur] = find1(n, e, rest - 1, 2);
            return dp[rest][cur];
        }

        //来到最后一个位置，只能去n-1
        if (cur == n) {
            dp[rest][cur] = find1(n, e, rest - 1, n - 1);
            return dp[rest][cur];
        }

        //中间位置，可以往左或者往右
        dp[rest][cur] = find1(n, e, rest - 1, cur - 1) + find1(n, e, rest - 1, cur + 1);
        return dp[rest][cur];
    }


    public static int ways(int n, int m, int k, int p){
        if (n<2||k<1||m<1||m>n||p<1||p>n){
            return 0;
        }
        return find3(n,p,m,k);
    }
    /**
     * 严格表结构动态规划
     *p==start
     * m=end
     *O(kn)
     */
    public static int find3(int n, int p, int m, int k) {
        int[][] dp = new int[k + 1][n + 1];  //dp[..][0]此列没有用，因为n的范围是1-n
        dp[0][p] = 1; //rest是0时，只有0行e列为1， dp[rest][cur] = cur == e ? 1 : 0;
        for (int rest = 1; rest <= k; rest++) {
            for (int cur = 1; cur <= n; cur++) {
                if (cur == 1) {
                    dp[rest][cur] = dp[rest - 1][2]; // dp[rest][cur] = find1(n, e, rest - 1, 2);
                } else if (cur == n) {
                    dp[rest][cur] = dp[rest - 1][n - 1];
                } else {
                    dp[rest][cur] = dp[rest - 1][cur - 1] + dp[rest - 1][cur + 1];
                }
            }
        }
        return dp[m][k];
    }
}
