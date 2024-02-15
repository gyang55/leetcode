package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1656 {
    class OrderedStream {
        private String[] stream;
        private int prt;

        public OrderedStream(int n) {
            stream = new String[n + 1];
            prt = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> res = new ArrayList<>();
            while (prt < stream.length && stream[prt] != null) {
                res.add(stream[prt]);
                ++prt;
            }
            return res;
        }
    }
}
