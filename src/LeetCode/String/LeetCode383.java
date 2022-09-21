package LeetCode.String;

public class LeetCode383 {
    /**
     * magazine 的字符串长度必须大于等于ransomnote
     * 先遍历magazine，统计字符出现的次数
     * 再遍历ransomNote，如果一个字符出现次数多余magazine的，则return false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()
        ) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()
        ) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
