package sort;

import java.util.PriorityQueue;

public class JZ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> big = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for (Integer n : arr
        ) {
            big.add(n);
            System.out.println(big);
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

    public static void main(String[] args){
        int[] arr = {2,4,5,24,23,45};

        System.out.println(new JZ40().getLeastNumbers(arr,3));
    }
}
