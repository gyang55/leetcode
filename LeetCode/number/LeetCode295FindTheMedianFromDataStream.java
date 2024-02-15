package LeetCode.number;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295FindTheMedianFromDataStream {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public LeetCode295FindTheMedianFromDataStream() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    void printLargeAndSmall() {
        System.out.println("Large:");
        while (!large.isEmpty()) {
            System.out.print(large.poll() + " ");
        }
        System.out.println();
        System.out.println("Small:");
        while (!small.isEmpty()) {

            System.out.print(small.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetCode295FindTheMedianFromDataStream leetCode295FindTheMedianFromDataStream =
                new LeetCode295FindTheMedianFromDataStream();
        leetCode295FindTheMedianFromDataStream.addNum(1);
        leetCode295FindTheMedianFromDataStream.addNum(2);
        leetCode295FindTheMedianFromDataStream.addNum(3);
        leetCode295FindTheMedianFromDataStream.addNum(4);
        leetCode295FindTheMedianFromDataStream.addNum(8);
        leetCode295FindTheMedianFromDataStream.printLargeAndSmall();

    }
}
