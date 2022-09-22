package LeetCode.String;

public class JZ05 {
    /**
     * 替换空格
     */
    class Solution {
        public String replaceSpace(String s) {
            char[] arr = s.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (char a : arr
            ) {
                stringBuffer.append(a == ' ' ? "%20" : a);
            }
            return stringBuffer.toString();
        }
    }

}
