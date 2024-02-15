package LeetCode.String;

public class Leetcode1422MaxScoreAfterSplittingAString {
    public int maxScore(String s) {
        int score = 0;
        int len = s.length();

        //first iteration cals the score split from position 1;
        if (s.charAt(0) == '0') {
            score++;
        }
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '1') {
                score++;
            }
        }

        //section iteration moves split point to the right, keep the max score
        int ans = score;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                score++;
            } else {
                score--;
            }
            ans =Math.max(ans, score);
        }

        return ans;
    }
}
