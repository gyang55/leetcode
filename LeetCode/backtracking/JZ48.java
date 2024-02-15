package LeetCode.backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class JZ48 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     * 思路：：哈希表记录字符位置
     * <p>
     * 当前字符位置cur 最近相同字符位置 pre
     * 如果 pre的位置 在dp[i-1]之外 cur = dp[i-1]+1
     * 如果pre的位置 在dp[i-1]之内，cur = cur-pre
     */

//    public int lengthOfLongestSubstring(String s) {
//        char[] arr = s.toCharArray();
//        int length = arr.length;
//        HashMap<Character, Integer> position = new HashMap<>();
//        int res = 0, temp = 0;
//        for (int i = 0; i < length; i++) {
//            int pre = position.getOrDefault(arr[i], -1);
//            position.put(arr[i], i);
//            temp = temp < i - pre ? temp + 1 : i - pre;
//            res = Math.max(res, temp);
//        }
//        return res;
//    }


    //sliding window
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int rightBorder = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightBorder+1 < n && !set.contains(s.charAt(rightBorder+1))) {
                set.add(s.charAt(rightBorder + 1));
                rightBorder++;
            }
            ans = Math.max(ans, rightBorder - i + 1);
        }
        return ans;
    }
}
