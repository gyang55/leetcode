package search;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode1346CheckIfNAndItsDoubleExist {
    class Solution {
        public boolean checkIfExist(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : arr) {
                if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2)))
                    return true;
                set.add(i);
            }
            return false;
        }
    }


}
