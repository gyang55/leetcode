package LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class Leetcode731 {

        Map<Integer, int[]> tree;

        public Leetcode731() {
            tree = new HashMap<Integer, int[]>();
        }

        public boolean book(int start, int end) {
            update(start, end - 1, 1, 0, 1000000000, 1);
            tree.putIfAbsent(1, new int[2]);
            if (tree.get(1)[0] > 2) {
                update(start, end - 1, -1, 0, 1000000000, 1);
                return false;
            }
            return true;
        }

        public void update(int start, int end, int val, int l, int r, int idx) {
            if (r < start || end < l) {
                return;
            }
            tree.putIfAbsent(idx, new int[2]);
            if (start <= l && r <= end) {
                tree.get(idx)[0] += val;
                tree.get(idx)[1] += val;
            } else {
                int mid = (l + r) >> 1;
                update(start, end, val, l, mid, 2 * idx);
                update(start, end, val, mid + 1, r, 2 * idx + 1);
                tree.putIfAbsent(2 * idx, new int[2]);
                tree.putIfAbsent(2 * idx + 1, new int[2]);
                tree.get(idx)[0] = tree.get(idx)[1] + Math.max(tree.get(2 * idx)[0], tree.get(2 * idx + 1)[0]);
            }
        }

        /**
         * 区间开始为1,结束为-1，每次加入booking，从头检查最大值是否超过3。超过了，减掉刚才加入的booking，不超过就往下
         * */




}
