package LeetCode.arrays;

public class LeetCode1450NumOfStudentDoingHomeWork {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            int startTimeI = startTime[i];
            int endTimeI = endTime[i];
            if (startTimeI <= queryTime && endTimeI >= queryTime) {
                res++;
            }
        }
        return res;
    }
}
