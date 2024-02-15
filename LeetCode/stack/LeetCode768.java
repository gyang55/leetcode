package LeetCode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode768 {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int num : arr) {
            //每次入栈，就表示这个值是前面分好组的最大值
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                //与前面的组融合，直到不能再融合。则这中间的最大值都已经融合到相同的组中，而这些最大值现在已经不是最大值了，需要去掉。
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }
}
