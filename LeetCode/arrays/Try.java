package LeetCode.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class Try {

    public static int[] findCommonElements(int[] a, int[] b, int[] c) {
        if(a.length==0&&b.length==0&&c.length==0){
            return new int[]{};
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            record.put(a[i], 1);
        }
        for (int n : b
        ) {
            if (record.containsKey(n)) {
                record.put(n, record.get(n) + 1);
            }
        }

        for (int n : c
        ) {
            if (record.containsKey(n)) {
                record.put(n, record.get(n) + 1);
                if (record.get(n) == 3) {
                    res.add(n);
                }
            }
        }

        if (res.isEmpty()) {
            return new int[]{};
        }

        int[] result = new int[res.size()];
        int index=0;
        for (int n: res
             ) {
            result[index++] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        int[] c = {};
        int[] commonElements = findCommonElements(a, b, c);
        if (commonElements.length==0){
            System.out.print("no");
        }else {
            for (int n : commonElements
            ) {
                System.out.print(n + " ");
            }
        }

    }
}
