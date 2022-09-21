package sort;

import java.util.HashMap;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for (Integer n:nums
             ) {
            if (count.containsKey(n)){
                count.put(n,count.get(n)+1);
                if (count.get(n)>nums.length/2){
                    return n;
                }
            }else {
                count.put(n,1);
            }

        }
        return -1;
    }

    /**
     * Moor Vote
     * */
//    public int majorityElement(int[] nums) {
//        int cand_num = nums[0], count = 1;
//        for (int i = 1; i < nums.length; ++i) {
//            if (cand_num == nums[i])
//                ++count;
//            else if (--count == 0) {
//                cand_num = nums[i];
//                count = 1;
//            }
//        }
//        return cand_num;
//    }


}
