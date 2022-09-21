package LeetCode.String;

public class LeetCode557ReverseWordsInAString3 {
    public String reverseWords(String s) {
        int preWhiteSpace = 0;
        char[] charArray = s.toCharArray();
        int start = 0;
        while (preWhiteSpace < s.length()) {
            preWhiteSpace = findNextWhiteSpace(charArray, start);
            reverseString(charArray, start, preWhiteSpace - 1);
            start = preWhiteSpace + 1;
        }
        return String.valueOf(charArray);

    }

    private int findNextWhiteSpace(char[] s, int start) {
        for (int i = start; i < s.length; i++) {
            if (s[i] == ' ') {
                return i;
            }
        }
        return s.length;
    }

    public void reverseString(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        System.out.print(new LeetCode557ReverseWordsInAString3().reverseWords(s));
    }
}
