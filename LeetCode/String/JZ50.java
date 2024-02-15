package LeetCode.String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JZ50 {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    class Solution {
//        public char firstUniqChar(String s) {
//            if(s.length()==0){
//                return ' ';
//            }
//            HashMap<Character, Integer> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                Character c = s.charAt(i);
//                if (!map.containsKey(c)) {
//                    map.put(c, 1);
//                } else {
//                    map.put(c, map.get(c) + 1);
//                }
//            }
//            int first = -1;
//            for (int i = 0; i < s.length(); i++) {
//                if (map.get(s.charAt(i)) == 1) {
//                    first = i;
//                    break;
//                }
//            }
//            return first == -1? ' ' : s.charAt(first);
//        }

        /**
         * 有序hashmap
         */
        public char firstUniqChar(String s) {
            Map<Character, Boolean> map = new LinkedHashMap<>();
            char[] arr = s.toCharArray();
            for (char c : arr
            ) {
                map.put(c, !map.containsKey(c));
            }
            for (Map.Entry<Character, Boolean> d : map.entrySet()
            ) {
                if (d.getValue()) return d.getKey();
            }

            return ' ';
        }
    }

    public static void main(String[] args) {
        new JZ50().new Solution().firstUniqChar("leeetcode");
    }
}
