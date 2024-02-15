package LeetCode.recursive;

import java.util.ArrayList;

public class PrintAllPermutations {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    //str[i.]范围上，所有的字符，都可以在位置上，后续都可以去尝试
    //str[0..i-1]范围上，是之前做的选择
    //请把所有的字符串行的全排列，加到res上面去
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        String test1 = "abc";
        ArrayList<String> res = Permutation(test1);
        System.out.println(res);
    }
}
