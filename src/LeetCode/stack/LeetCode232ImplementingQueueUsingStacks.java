package LeetCode.stack;

import java.util.Stack;

public class LeetCode232ImplementingQueueUsingStacks {
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
    private int front;

    public LeetCode232ImplementingQueueUsingStacks() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
        this.front = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (stackOne.empty())
            front = x;
        stackOne.push(x);
    }

    public int pop() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty())
                stackTwo.push(stackOne.pop());
        }
        return stackTwo.pop();
    }

    public int peek() {
        if (!stackTwo.isEmpty()) {
            return stackTwo.peek();
        }
        return front;
    }

    public boolean empty() {
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }
}
