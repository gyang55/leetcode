package LeetCode.dynamic;

public class LeetCode45JUmpGame2 {
    /**
     * EveryTime reach end, step ++; within end, we just try max next end.
     */
    public int jump(int[] nums) {
        int end = 0;
        int steps = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }
}
