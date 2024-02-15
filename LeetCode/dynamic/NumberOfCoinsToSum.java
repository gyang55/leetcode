package LeetCode.dynamic;

public class NumberOfCoinsToSum {
    /**
     * 给一个整数数组，求最小个数coin加起来是一个数
     * */

    /**
     * arr 硬币都在其中，固定参数
     * aim 最终要加起来的数
     * 如果自由选择arr[index..]这些硬币，之前的总数为pre
     */

    public static int minCoins1(int[] arr, int aim) {
        return find1(arr, 0, aim);
    }

    public static int find1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }

        if (rest == 0) {
            return 0;
        }
        //rest>0
        if (index == arr.length) {
            return -1;
        }

        int p1 = find1(arr, index + 1, rest);
        int p2 = find1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            }
            if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }

    /**
     * 计划搜索
     */
    public static int minCoins2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return find2(arr, 0, aim, dp);
    }

    public static int find2(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }

        if (rest == 0) {
            dp[index][rest] = 0;

        } else if (index == arr.length) {
            dp[index][rest] = -1;

        } else {
            int p1 = find2(arr, index + 1, rest, dp);
            int p2 = find2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2 == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2 + 1;
                } else if (p2 == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2 + 1);
                }
            }
        }
        return dp[index][rest];
    }


    public static int minCoin3(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        // if (rest == 0) {
        //            dp[index][rest] = 0;
        //
        //        } else if (index == arr.length) {
        //            dp[index][rest] = -1;
        for (int row = 0; row < arr.length; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[arr.length][col] = -1;
        }

        // 从下往上开始填,从左往右
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {


                int p1 = dp[index + 1][rest];
                int p2 = -1; //rest-arr[index]有可能越界
                if (rest - arr[index] >= 0) {
                    p2 = dp[index + 1][rest - arr[index]];
                }
                if (p1 == -1 && p2 == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
