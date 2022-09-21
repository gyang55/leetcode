import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;

/**
 * <p>
 * PasscodeFinder uses two different methods to find passcode in a sorted array of Integers.
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class PasscodeFinder {
    /**
     * intArr stores data read from data files
     */
    ArrayList<Integer> intArr = new ArrayList<>();

    /**
     * bruteForceCount stores the comparisons times of getPasscodeBruteForce()
     */
    private int bruteForceCount = 0;

    /**
     * binarySearchCount stores the comparisons times of getPasscodeBinarySearch()
     */
    private int binarySearchCount = 0;

    /**
     * <p>
     * Use brute force method to find the password
     * </p>
     *
     * //@param intArr the sorted array of integers
     */
     public Integer getPasscodeBruteForce(Integer[] intArr) {
         int index = 0;
         for (int i = 0; i < intArr.length; i++) {//Loop through the array starting from first element
             bruteForceCount++;
             if (intArr[i].intValue() != i) { // See if the element value equals its index value
                 index = i;
                 break;
             }
         }

         if (index == 0 && intArr[index] == 0) { // If there is no passcode found in the array and the first element is 0
             return intArr.length;               // Then the passcode is the next integer of the last element
         } else {
             return index;               // Otherwise, the passcode is the 0
         }
     }

    /**
     * <p>
     * Count and return comparison times of getPasscodeBruteForce()
     * </p>
     *
     * @return bruteForceCount, the comparison times
     */
    public int bruteForceComparisons() {
        return bruteForceCount;
    }

    /**
     * <p>
     * Use binary search method to find the password
     * </p>
     *
     * @param intArr the sorted array of integers
     */
    public int getPasscodeBinarySearch(Integer[] intArr) {
        //If the first element is not 0, then passcode is 0
        if (intArr[0] != 0) {
            return 0;
        }

        //Declare there indices pointer
        int start = 0, mid = 0,
                end = intArr.length - 1;

        //End loop if start index and end index is next to each other
        while ((end - start) > 1) {
            binarySearchCount++;
            mid = (start + end) / 2;

            /* Move start index pointer to mid if passcode is in first half of the array, or, move the end index
            pointer to mid if passcode is in second half of the array. Otherwise, the passcode is the integer next to
            the last element of the array
            */
            if ((intArr[start] - start) != (intArr[mid] - mid)) {
                end = mid;
            } else if ((intArr[end] - end) != (intArr[mid] - mid)) {
                binarySearchCount++;
                start = mid;
            } else {
                return intArr.length;
            }
        }
        return (intArr[start] + 1);
    }

    /**
     * <p>
     * Count and return comparison times of getPasscodeBinarySearch()
     * </p>
     *
     * @return binarySearchCount, the comparison times
     */
    public int binarySearchComparison() {
        return binarySearchCount;
    }


    /**
     * <p>
     * Read data from data files and stores the data into intArr
     * </p>
     *
     * @param fileName, the name of target data file
     */
    public void readFile(String fileName) {
        File file = new File(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while (scan.hasNext()) {
                intArr.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scan.close();
    }

    /**
     * <p>
     * Sort array of Integers
     * </p>
     *
     * @param arr, the input unsorted array of Integers
     * @return array, the sorted Integer array
     */
    public Integer[] sortList(ArrayList arr) {
        Integer[] sortedList = new Integer[arr.size()];
        Iterator<Integer> iterator = intArr.iterator();
        for (int i = 0; i < intArr.size(); i++) {
            sortedList[i] = iterator.next();
        }
        Arrays.sort(sortedList);
        return sortedList;
    }


    public static void main(String args[]) {
        PasscodeFinder passcodeFinder = new PasscodeFinder();
        String path = "C:\\BCIT\\COMP3760\\week4\\lab\\pc99.txt";
        passcodeFinder.readFile(path);
        Integer[] result = passcodeFinder.sortList(passcodeFinder.intArr);
        System.out.println("The passcode found by Brute force p is: " + passcodeFinder.getPasscodeBruteForce(result));
        System.out.println("Brute force LeetCode.number of comparisons is: " + passcodeFinder.bruteForceComparisons());
        System.out.println("The passcode found by Binary search is: " + passcodeFinder.getPasscodeBinarySearch(result));
        System.out.println("Binary search password comparisons is: " + passcodeFinder.binarySearchComparison());


    }
}






