package LeetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1331RankTransformOFAnArray {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> ranks = new HashMap<>();
        int[] copy = new int[arr.length];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int pre = 0;
        int rank = 1;
        for (int i = 0; i < copy.length; i++) {
            if (i == 0) {
                ranks.put(copy[i], rank);
                pre = copy[i];
                continue;
            }
            if (copy[i] == pre) {
                ranks.put(copy[i], rank);
            } else {
                ranks.put(copy[i], ++rank);
                pre = copy[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = ranks.get(arr[i]);
        }
        return res;
    }
}
