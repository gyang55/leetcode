import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * Lab5 Reads names from files and put them into customized hash table, and count the collisions.
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class Lab5 {
    private ArrayList<int[][]> finalResults = new ArrayList<>();

    /**
     * <p>
     * Read data from data files and stores the data into names
     * </p>
     *
     * @param fileName, the name of target data file
     * @return LeetCode.String array, names
     */
    public String[] readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String scannedString = scan.nextLine();
        String[] names = scannedString.split(",");

        scan.close();
        return names;
    }

    /**
     * <p>
     * Intake a name and return the index of the bucket where the name should be put in
     * </p>
     *
     * @param name,      the name in the array names
     * @param tableSize, the hash table size
     * @return table bucket index, int
     */
    public int H1(String name, int tableSize) {
        int letterValue = 0;
        name = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            letterValue += name.charAt(i) - 'a' + 1;
        }
        return letterValue % tableSize;
    }

    /**
     * <p>
     * Intake a name and return the index of the bucket where the name should be put in
     * </p>
     *
     * @param name,      the name in the array names
     * @param tableSize, the hash table size
     * @return table bucket index, long
     */
    public long H2(String name, int tableSize) {
        long letterValue = 0;
        name = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            letterValue += (name.charAt(i) - 'a' + 1) * Math.pow(26, i);
        }

        return letterValue % tableSize;
    }

    /**
     * <p>
     * Intake a name and return the index of the bucket where the name should be put in
     * </p>
     *
     * @param name,      the name in the array names
     * @param tableSize, the hash table size
     * @return table bucket index, int
     */
    public int H3(String name, int tableSize) {
        int letterValue = 0;
        //Multiply each char's uppercase and lowercase ascii value, and then times its position + 1
        for (int i = 0; i < name.length(); i++) {
            letterValue += (name.charAt(i)) * (Character.toLowerCase(name.charAt(i))) * (i + 1);
        }
        return letterValue % tableSize;
    }

    /**
     * <p>
     * Intake an array of names and customized arrayList
     * </p>
     *
     * @param names,        array of names
     * @param cusHash,      the customized hash table
     * @param tableSize,    cusHash size
     * @param hashFunction, hash function name
     * @return collisions, the LeetCode.number of collisions
     */
    public int checkCollisions(String[] names, String[] cusHash, int tableSize, String hashFunction) {
        int collisions = 0;
        int index = 0;
        for (String name : names
        ) {
            switch (hashFunction) {
                case "H1":
                    index = H1(name, tableSize);
                    break;
                case "H2":
                    index = (int) H2(name, tableSize);
                    break;
                case "H3":
                    index = H3(name, tableSize);
                    break;
                default:
                    break;
            }
            if (collisionOrNot(cusHash, index)) {
                collisions++;
                cusHash[nextEmptyBucket(cusHash, index, tableSize)] = name;
            } else {
                cusHash[index] = name;
            }
        }

        return collisions;
    }

    /**
     * <p>
     * Checks whether a collision happens
     * </p>
     *
     * @param cusHash, the customized hash table
     * @param index,   the initial index where name should put in
     * @return true if there is a collision
     */
    public boolean collisionOrNot(String[] cusHash, int index) {
        if (cusHash[index] == null) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * If there is a collision, find the next available bucket and return the index
     * </p>
     *
     * @param cusHash,   the customized hash table
     * @param index,     the initial index where name should put in
     * @param tableSize, cusHash size
     * @return findIndex, the next available bucket index.
     */
    public int nextEmptyBucket(String[] cusHash, int index, int tableSize) {
        int findIndex = index + 1;

        while (true) {
            if (findIndex == tableSize) {
                findIndex = 0;
            }
            if (cusHash[findIndex] == null) {
                break;
            }
            findIndex++;

        }
        return findIndex;
    }


    /**
     * <p>
     * Read files and return result numbers by three hash functions
     * </p>
     *
     * @param filename, the name of the file
     */
    public void DoTheStuff(String filename) {
        File file = new File(filename);
        String nameOfFile = file.getName().toString();
        int[][] results = new int[4][4];
        String[] names = {};
        try {
            names = readFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int length = names.length;
        String[] table1_1 = new String[length];
        String[] table1_2 = new String[length];
        String[] table1_3 = new String[length];
        String[] table2_1 = new String[length * 2];
        String[] table2_2 = new String[length * 2];
        String[] table2_3 = new String[length * 2];
        String[] table3_1 = new String[length * 5];
        String[] table3_2 = new String[length * 5];
        String[] table3_3 = new String[length * 5];
        String[] table4_1 = new String[length * 10];
        String[] table4_2 = new String[length * 10];
        String[] table4_3 = new String[length * 10];

        for (int j = 0; j < 4; j++) {
            switch (j) {
                case 0:
                    results[j][0] = length;
                    results[j][1] = checkCollisions(names, table1_1, length, "H1");
                    results[j][2] = checkCollisions(names, table1_2, length, "H2");
                    results[j][3] = checkCollisions(names, table1_3, length, "H3");
                    System.out.format("%10s%15d%15d%15d%15d", nameOfFile, results[j][0], results[j][1], results[j][2], results[j][3]);
                    System.out.println();
                    break;
                case 1:
                    results[j][0] = length * 2;
                    results[j][1] = checkCollisions(names, table2_1, length * 2, "H1");
                    results[j][2] = checkCollisions(names, table2_2, length * 2, "H2");
                    results[j][3] = checkCollisions(names, table2_3, length * 2, "H3");
                    System.out.format("%10s%15d%15d%15d%15d", nameOfFile, results[j][0], results[j][1], results[j][2], results[j][3]);
                    System.out.println();
                    break;
                case 2:
                    results[j][0] = length * 5;
                    results[j][1] = checkCollisions(names, table3_1, length * 5, "H1");
                    results[j][2] = checkCollisions(names, table3_2, length * 5, "H2");
                    results[j][3] = checkCollisions(names, table3_3, length * 5, "H3");
                    System.out.format("%10s%15d%15d%15d%15d", nameOfFile, results[j][0], results[j][1], results[j][2], results[j][3]);
                    System.out.println();
                    break;
                case 3:
                    results[j][0] = length * 10;
                    results[j][1] = checkCollisions(names, table4_1, length * 10, "H1");
                    results[j][2] = checkCollisions(names, table4_2, length * 10, "H2");
                    results[j][3] = checkCollisions(names, table4_3, length * 10, "H3");
                    System.out.format("%10s%15d%15d%15d%15d", nameOfFile, results[j][0], results[j][1], results[j][2], results[j][3]);
                    System.out.println();
                    break;
            }
        }
        finalResults.add(results);
    }

    public static void main(String args[]) throws FileNotFoundException {
        Lab5 lab5 = new Lab5();
        System.out.format("%8s%25s%15s%15s%15s", "File Name", "Hash Table Size", "H1 collisions", "H2 collisions", "H3 collisions");
        System.out.println();
        lab5.DoTheStuff("C:\\BCIT\\COMP3760\\week6\\37_names.txt");
        lab5.DoTheStuff("C:\\BCIT\\COMP3760\\week6\\333_names.txt");
        lab5.DoTheStuff("C:\\BCIT\\COMP3760\\week6\\5163_names.txt");

    }
}

