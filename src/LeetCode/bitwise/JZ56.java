package LeetCode.bitwise;

public class JZ56 {
    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     */
//    public int[] singleNumbers(int[] nums) {
//        int x = 0, y = 0, n = 0, m = 1;
//        for (int num : nums
//        ) {
//            n ^= num; //find first XOR second
//        }
//        while ((n & m) == 0) {
//            m <<= 1; // find first 1 in first XOR second
//        }
//
//        for (int num : nums
//        ) {
//            if ((num & m) != 0) x ^= num;
//            else y ^= num;                  // to divide first and second into two groups
//        }
//        return new int[]{x, y};
//    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     */
    public int singleNumber(int[] nums) {
        int mask = 1 << 31;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bisSum = 0;
            for (int num : nums
            ) {
                if ((num & mask) != 0) {
                    bisSum++;
                }
            }
            res = (res << 1) + (bisSum % 3);
            mask >>= 1;
        }
        return res;
    }
}
