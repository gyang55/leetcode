package LeetCode.recursive;

public class PrintAllSubsequences {
    //相当于求出一个string的子集
    public static void printAllSubsequence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] str, int i) {
        if (i == str.length) {
            printString(str);
            return;
        }
        process(str, i + 1);
        char temp = str[i];
        str[i] = 0;
        process(str, i + 1);
        str[i] = temp;
    }

    private static void printString(char[] str) {
        for (char c : str
        ) {
            if (c == 0) {
                System.out.print("");
            } else {
                System.out.print(c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllSubsequence(test1);
    }
}
