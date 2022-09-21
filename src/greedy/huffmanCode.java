package greedy;

import java.util.PriorityQueue;

public class huffmanCode {
    public static int sum(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        int cur;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int sum = huffmanCode.sum(arr);
        System.out.println(sum);
    }
}
