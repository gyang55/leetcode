package LeetCode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Leetcode239SlidingWindowMaximum {
    public class WindowMax {
        private int L;
        private int R;
        private int[] arr; //arr[(L..R)]
        private ArrayDeque<Integer> qmax;

        public WindowMax(int[] arr) {
            L = -1;
            R = 0;
            this.arr = arr;
            this.qmax = new ArrayDeque<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }

            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            R++;
        }

        public void removeNumFromLeft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
        }

        public Integer getMax() {
            if (!qmax.isEmpty()) {
                return arr[qmax.pollFirst()];
            }
            return null;
        }

        public static int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k < 1 || nums.length < k) {
                return null;
            }

            //下标，值 大-》小
            ArrayDeque<Integer> qmax = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                    qmax.pollLast();
                }
                qmax.addLast(i);
                if (qmax.peekFirst() == i - k) { //过期的下标 i-w
                    qmax.pollFirst();
                }
                if (i >= k - 1) {//形成窗口
                    res[index++] = nums[qmax.peekFirst()];
                }
            }
            return res;
        }
    }
}
