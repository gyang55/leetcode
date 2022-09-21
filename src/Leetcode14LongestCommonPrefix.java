import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }
    //official solution
    /**
     * Each time get a char from first string, Then check whether the char in following strings are the same, if not,
     * make a substring from 0 to this char index
     * */
//    public LeetCode.String longestCommonPrefix(LeetCode.String[] strs) {
//        if (strs == null || strs.length == 0) return "";
//        for (int i = 0; i < strs[0].length() ; i++){
//            char c = strs[0].charAt(i); // 保存 i 列第 0 行的字符便于后续比较
//            //比较第 1,2,3... 行的字符和第 0 行是否相等
//            for (int j = 1; j < strs.length; j ++) {
//                /**
//                 * i == strs[j].length() 表明当前行已经到达末尾
//                 * strs[j].charAt(i) != c  当前行和第 0 行字符不相等
//                 * 上边两种情况返回结果
//                 */
//                if (i == strs[j].length() || strs[j].charAt(i) != c)
//                    return strs[0].substring(0, i);
//            }
//        }
//        return strs[0];
//    }
    public static void main(String[] args) {
        Leetcode14LongestCommonPrefix leetcode14LongestCommonPrefix = new Leetcode14LongestCommonPrefix();
        String[] strs = {"geeks", "zgak", "geek", "geeksl"};
        if (leetcode14LongestCommonPrefix.longestCommonPrefix(strs).isBlank()){
            System.out.println("Empty");
        }else{
            System.out.println(leetcode14LongestCommonPrefix.longestCommonPrefix(strs));
        }
    }
}
