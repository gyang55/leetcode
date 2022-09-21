package LeetCode.String;

import java.util.LinkedList;
import java.util.List;

public class Leetcode1408StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
