package LeetCode.dynamic;

public class LeetCode413ArithmeticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return 0;
        }
        int preBefore = nums[0];
        int before = nums[1];
        int slice = 2;
        int res = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] - before == before - preBefore) {
                res = res + slice - 1;
                slice++;
            } else {
                slice = 2;
            }
            preBefore = before;
            before = nums[i];
        }
        return res;
    }
}
