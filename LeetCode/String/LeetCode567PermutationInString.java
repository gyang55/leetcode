package LeetCode.String;

public class LeetCode567PermutationInString {
    // sliding window
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int diff = 0;
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        //size of sliding window is n
        for (int i = 0; i < n; i++) {
            --count[s1.charAt(i) - 'a'];
            ++count[s2.charAt(i) - 'a'];
        }

        for (int in : count
        ) {
            if (in != 0) {
                diff++;
            }
        }

        if (diff == 0) {
            return true;
        }

        for (int i = n; i < m; i++) {
            int in = s2.charAt(i) - 'a';
            int out = s2.charAt(i - n) - 'a';
            if (count[in] == 0) {
                diff++;
            }
            ++count[in];
            if (count[in] == 0) {
                --diff;
            }

            if (count[out] == 0) {
                diff++;
            }

            --count[out];
            if (count[out] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}
