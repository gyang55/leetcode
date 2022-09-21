package LeetCode.String;

public class Leetcode28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        return kmp(haystack, needle);

    }

    private int kmp(String str, String pattern) {
        char[] strChar = str.toCharArray();
        char[] patternChar = pattern.toCharArray();

        int strIndex = 0;
        int patternIndex = 0;

        int[] next = getNextArray(patternChar);

        while (strIndex < str.length() && patternIndex < pattern.length()) {
            if (strChar[strIndex] == patternChar[patternIndex]) {
                strIndex++;
                patternIndex++;
            } else if (patternIndex == 0) {
                strIndex++;
            } else {
                patternIndex = next[patternIndex];
            }
        }
        return patternIndex == pattern.length() ? strIndex - patternIndex : -1;
    }

    private int[] getNextArray(char[] charArray) {
        if (charArray.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[charArray.length];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cn = 0;

        while (index < next.length) {
            if (charArray[index - 1] == charArray[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Leetcode28ImplementstrStr leetcode28ImplementstrStr = new Leetcode28ImplementstrStr();
        int res = leetcode28ImplementstrStr.strStr(haystack, needle);
        System.out.println(res);
    }
}
