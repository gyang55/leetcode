import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Pythagorean {
    public static ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public static void findPythagorean(int sum) {
        for (int i = 1; i < sum; i++) {
            for (int j = i + 1; j < sum; j++) {
                for (int k = j + 1; k < sum; k++) {
                    if (i + j + k <= sum && (i*i + j*j == k*k)) {
                        ArrayList<Integer> group = new ArrayList<>();
                        group.add(i);
                        group.add(j);
                        group.add(k);
                        results.add(group);
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        long startTime = System.nanoTime();
        findPythagorean(100000);
        long endTime = System.nanoTime();
        System.out.println(results.size());
        long elapsedTime = endTime-startTime;
        long seconds = TimeUnit.SECONDS.convert(elapsedTime,TimeUnit.NANOSECONDS);
        System.out.println(seconds);

    }
}
