package LeetCode.String;

import java.util.HashMap;

public class LeetCode3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j =  Math.max(j,(1 + map.get(c))); //the lower pointer pointing to the next char of repetitive char
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args){
        String a = "abba";

        System.out.print(new LeetCode3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(a));
    }
}
