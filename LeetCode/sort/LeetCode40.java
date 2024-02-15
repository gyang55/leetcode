package sort;

import java.util.PriorityQueue;

public class LeetCode40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> big = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for (Integer n : arr
        ) {
            big.add(n);
            if (big.size() > k) {
                big.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = big.poll();
        }
        return res;
    }
}
