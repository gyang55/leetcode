package LeetCode.math;

public class JZ39 {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    //moor votes
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int n : nums
        ) {
            if (votes == 0) x = n;
            votes += n == x ? 1 : -1;
        }
        return x;
    }
}
