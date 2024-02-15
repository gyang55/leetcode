package LeetCode.dynamic;

public class LeetCode55JumpGame {
    public static boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        canJump(arr);
    }
}
