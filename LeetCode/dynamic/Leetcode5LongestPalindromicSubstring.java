package LeetCode.dynamic;

public class Leetcode5LongestPalindromicSubstring {
    /**
     * Dynamic programming
     * s[i]=s[j], see if dp[i+1][j-1] is palindrome
     * i+1 and j-1 must satisfy j-1 - (i+1) +1 > 2, if j-1-(i+1) +1<2, there is nothing in between, no
     * need to determine palindrome. so j-i>3. if j-i>3, see if dp[i+1][j-1] is palindrome
     */
//    public String longestPalindrome(String s) {
//        if (s.length() < 2) {
//            return s;
//        }
//        int maxLength = 1;
//        int begin = 0;
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            dp[i][i] = true;
//        }
//        char[] charArray = s.toCharArray();
//        //only fill up the right up part of the two dimension array
//        for (int l = 2; l <= s.length(); l++) {
//            for (int i = 0; i < s.length(); i++) {
//                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
//                int j = l + i - 1;
//                // 如果右边界越界，就可以退出当前循环
//                if (j >= s.length()) {
//                    break;
//                }
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLength) {
//                    maxLength = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLength);
//    }

    /**
     * expand from center
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
