
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * Triplets is used to find the combinations of three Integers in a data file
 * whose sum is the multiples of 37
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class Triplets {
    /**
     * Results contains all triplets, each of which contains in a separate ArrayList
     */
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    /**
     * rawDataList contains all the raw data after reading the data file
     */
    ArrayList<Integer> rawDataList = new ArrayList<>();

    /**
     * Path is the root path for all the data files.
     */
    private static String path = "C:\\BCIT\\COMP3760\\week2\\lab2\\";

    /**
     * <p>
     * readFile reads the data file under the root path, and stores the data into rawDataList.
     * </p>
     *
     * @param fileName the data file name
     */
    private void readFile(String fileName) {
        String filePath = path.concat(fileName);
        File file = new File(filePath);
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNext()) {
                rawDataList.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * This method tries to find all the possible triples whose sum is the multiple of 37
     * from the intList. If one triples is found, they will be stored in a new ArrayList which would
     * then be stored in results. At last, it will print how many triples found from the rawDataList.
     * </p>
     *
     * @param fileName the data file name
     */
    public void findTriplets(String fileName) {
        // read the file first and store the data from file into rawDataList
        readFile(fileName);


        for (int i = 0; i < rawDataList.size() - 2; i++) {  /*The outer loop starts from the first element in the
                                                              rawDataList to last element but two*/
            for (int j = i + 1; j < rawDataList.size() - 1; j++) { /*The middle loop starts from the first element after
                                                                    the outer loop element, and all the way to the
                                                                    second last element.
                                                                    */
                for (int k = j + 1; k < rawDataList.size(); k++) { /*The inner loop starts from the first element after
                                                                     the middle loop to the last element.
                                                                    */
                    // Get the sum of each triplet
                    double sum = rawDataList.get(i) + rawDataList.get(j) + rawDataList.get(k);
                    if (sum % 37 == 0) {    // If the remainder is 0, then the triplet is valid one
                        ArrayList<Integer> tripletList = new ArrayList<>(); // Create a ArrayList and store the valid triplet into it
                        tripletList.add(rawDataList.get(i));
                        tripletList.add(rawDataList.get(j));
                        tripletList.add(rawDataList.get(k));

                        //Finally store the tripletList into result
                        results.add(tripletList);
                    }
                }
            }
        }

        // Store the LeetCode.number of valid triples
        int numberOfTriples = results.size();

        //Print the all the valid triples based on the LeetCode.number of valid triples
        if (numberOfTriples == 0) {
            System.out.println("There is no triples in the data file whose sum is the multiples of 37.");
        } else if (numberOfTriples == 1) {
            System.out.println("There is only one triples in the data file whose sum is the multiples of 37."
                    + " The results is\n " + results);
        } else {
            System.out.println("There are " + numberOfTriples + " triples in the datafile whose sum is the multiples " +
                    "of 37 and the results are\n " + results);
        }
    }

    public static void main(String args[]) {
        Triplets triple = new Triplets();
        triple.findTriplets("data0.txt");
    }
}



