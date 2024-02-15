package sort;

public class InsertionSort {
    // O(n2)
    void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int insert = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > insert) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = insert;
        }
    }
}
