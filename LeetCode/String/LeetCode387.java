package LeetCode.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode387 {
    /**
     * 1. 用哈希表，存频次，便利两次string
     * 2. 用哈希表存位置，多次出现的为-1，第一次遍历string，第二次遍历哈希表
     * 3. 用哈希表存频次，用queue维护result，char不在哈希表中，则在queue中插入[char, frequency]，
     * 如果哈希表有这个字符，则哈希表改为[char，-1] 然后检查queue中不符合的poll出
     */
    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }

        public int firstUniqChar(String s) {
            HashMap<Character, Integer> position = new HashMap<>();
            Queue<Pair> queue = new LinkedList<Pair>();
            for (int i = 0; i < s.length(); i++) {
                if (position.containsKey(s.charAt(i))) {
                    position.put(s.charAt(i), -1);
                    while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                        queue.poll();
                    }
                } else {
                    position.put(s.charAt(i), i);
                    queue.offer(new Pair(s.charAt(i), i));
                }
            }
            return queue.isEmpty() ? -1 : queue.poll().ch;

        }
    }
}
