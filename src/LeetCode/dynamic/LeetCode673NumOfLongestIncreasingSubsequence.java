package LeetCode.dynamic;

public class LeetCode673NumOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int[] cacheLIS = new int[n], cacheFreg = new int[n];
        cacheLIS[n - 1] = 1;
        cacheFreg[n - 1] = 1;
        int maxLIS = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    if (cacheLIS[i] < cacheLIS[j]) {
                        cacheLIS[i] = cacheLIS[j];
                        cacheFreg[i] = cacheFreg[j];
                    } else if (cacheLIS[i] == cacheLIS[j]) {
                        cacheFreg[i] += cacheFreg[j];
                    }
                }
            }
            cacheLIS[i]++;
            cacheFreg[i] = Math.max(cacheFreg[i], 1);
            maxLIS = Math.max(maxLIS, cacheLIS[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (cacheLIS[i] == maxLIS) {
                total += cacheFreg[i];
            }
        }
        return total;
    }
}
