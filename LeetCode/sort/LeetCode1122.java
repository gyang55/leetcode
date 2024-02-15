package sort;

public class LeetCode1122 {
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        if (arr2 == null) {
//            return arr1;
//        }
//        int min = getMin(arr1);
//        int max = getMax(arr1);
//        int range = max - min + 1;
//        int[] arr1Count = new int[range];
//        int[] res = new int[arr1.length];
//        //
//        for (Integer n : arr1
//        ) {
//            arr1Count[n - min]++;
//        }
//        int index = 0;
//        for (Integer n : arr2
//        ) {
//            while (arr1Count[n - min] > 0) {
//                res[index++] = n;
//                arr1Count[n - min]--;
//            }
//        }
//        for (int i = 0; i < arr1Count.length; i++) {
//            if (arr1Count[i] == 0) {
//                continue;
//            }
//            while (arr1Count[i] != 0) {
//                res[index++] = i + min;
//                arr1Count[i]--;
//            }
//        }
//
//        for (int i = 0; i < res.length; i++) {
//            arr1[i] = res[i];
//        }
//
//        return arr1;
//    }
//
//    private int getMin(int[] arr1) {
//        int min = arr1[0];
//        for (Integer n : arr1
//        ) {
//            min = n < min ? n : min;
//        }
//        return min;
//    }
//
//    private int getMax(int[] arr1) {
//        int max = arr1[0];
//        for (Integer n : arr1
//        ) {
//            max = n > max ? n : max;
//        }
//        return max;
//    }

    /**
     * official one
     * */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {943,790,427,722,860,550,225,846,715,320};
        int[] arr2 = {943,715,427,790,860,722,225,320,846,550};
        new LeetCode1122().relativeSortArray(arr1, arr2);
        for (Integer n : arr1
        ) {
            System.out.print(n + " ");
        }
    }
}
