package LeetCode.dynamic;

public class Leetcode91DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && arr[i - 2] != '0' && ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
