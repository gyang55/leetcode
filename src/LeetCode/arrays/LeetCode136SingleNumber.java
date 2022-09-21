package LeetCode.arrays;

import java.util.HashMap;

public class LeetCode136SingleNumber {
//    public int singleNumber(int[] nums) {
//        int ans = 0;
//        HashMap<Integer, Integer> count = new HashMap<>();
//        for (int n : nums
//        ) {
//            count.put(n, count.getOrDefault(n, 0) + 1);
//            if (count.get(n) == 2) {
//                count.remove(n);
//            }
//        }
//        for (int n : count.keySet()
//        ) {
//            ans = n;
//        }
//        return ans;
//    }

    /**
     * 位运算
     * */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
