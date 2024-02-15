package LeetCode.String;

public class leetconde459RepeatedSubstringPattern {
    /**
     * 思路：如果一个string由一个pattern至少multiple 两次组成，则 string+string 由patternmultiple至少四次组成，
     * 掐头去尾 去掉两个pattern，那么这个substring至少要有两个pattern以上，也就是要有一个string以上，如果没有，则不行。
     */
    public boolean repeatedSubstringPattern(String s) {
        String newString = s.concat(s);
        return newString.substring(1, newString.length() - 1).contains(s);
    }
}
