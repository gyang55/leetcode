import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * <p>
 * MeetingSchedule Reads meeting requests from files and schedule non overlapping ones
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class MeetingSchedule {
    /**
     * Meetings read from files
     */
    ArrayList<Meeting> meetings;
    /**
     * Meetings length
     */
    int size;

    public MeetingSchedule() {
        meetings = new ArrayList<>();
    }

    /**
     * <p>
     * Read data from data files and stores the data into names
     * </p>
     *
     * @param fileName, the name of target data file
     */
    public void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        int lineNumber = 0;
        String name = null;
        int start;
        int end;
        while (scan.hasNextLine()) {
            if (lineNumber % 2 == 0) {
                name = scan.nextLine();
            } else {
                String[] time = scan.nextLine().split(" ");
                start = Integer.parseInt(time[0]);
                end = Integer.parseInt(time[1]);

                meetings.add(new Meeting(name, start, end));
            }
            lineNumber++;
        }
        scan.close();
        size = meetings.size();
    }

    /**
     * <p>
     * Sort meetings based on start time in ascending order.
     * </p>
     */
    private ArrayList<Meeting> rankedByStartTime() {
        Collections.sort(meetings, new SortByStartTime());
        return chooseMeetings();
    }

    /**
     * <p>
     * Sort meetings based on meeting duration in ascending order.
     * </p>
     */
    private ArrayList<Meeting> rankedByDuration() {
        Collections.sort(meetings, new SortByDuration());
        return chooseMeetings();
    }

    /**
     * <p>
     * Sort meetings based on end time in ascending order.
     * </p>
     */
    private ArrayList<Meeting> rankedByEndTime() {
        Collections.sort(meetings, new SortByEndTime());
        return chooseMeetings();
    }

    /**
     * Choose non-overlapped meetings based on sorted meetings.
     */
    private ArrayList<Meeting> chooseMeetings() {
        ArrayList<Meeting> scheduledMeetings = new ArrayList<>();

        for (Meeting meeting : meetings
        ) {
            boolean overlapped = false;
            if (scheduledMeetings.size() == 0) {
                scheduledMeetings.add(meeting);
            } else {
                for (Meeting scheduled : scheduledMeetings
                ) {
                    if (meeting.overlapsWith(scheduled)) {
                        overlapped = true;
                        break;
                    }
                }
                if (!overlapped) {
                    scheduledMeetings.add(meeting);
                }
            }
        }
        return scheduledMeetings;
    }

    public static void main(String args[]) throws FileNotFoundException {
        /**
         * data1.txt
         * */
        MeetingSchedule meetingScheduleData1 = new MeetingSchedule();
        meetingScheduleData1.readFile("C:\\BCIT\\COMP3760\\lab7\\data1.txt");

        ArrayList<Meeting> sortedByStartTimeData1 = meetingScheduleData1.rankedByStartTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#1(rank by Start)", sortedByStartTimeData1.size());
        System.out.println();
        for (Meeting meeting : sortedByStartTimeData1
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByDurationData1 = meetingScheduleData1.rankedByDuration();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#2(rank by Length)", sortedByDurationData1.size());
        System.out.println();
        for (Meeting meeting : sortedByDurationData1
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();
        ArrayList<Meeting> sortedByEndTimeData1 = meetingScheduleData1.rankedByEndTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#3(rank by End)", sortedByEndTimeData1.size());
        System.out.println();
        for (Meeting meeting : sortedByEndTimeData1
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        /**
         * data2.txt
         * */
        MeetingSchedule meetingScheduleData2 = new MeetingSchedule();
        meetingScheduleData2.readFile("C:\\BCIT\\COMP3760\\lab7\\data2.txt");

        ArrayList<Meeting> sortedByStartTimeData2 = meetingScheduleData2.rankedByStartTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#1(rank by Start)", sortedByStartTimeData2.size());
        System.out.println();
        for (Meeting meeting : sortedByStartTimeData2
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByDurationData2 = meetingScheduleData2.rankedByDuration();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#2(rank by Length)", sortedByDurationData2.size());
        System.out.println();
        for (Meeting meeting : sortedByDurationData2
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByEndTimeData2 = meetingScheduleData2.rankedByEndTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#3(rank by End)", sortedByEndTimeData2.size());
        System.out.println();
        for (Meeting meeting : sortedByEndTimeData2
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        /**
         * data3.txt
         * */
        MeetingSchedule meetingScheduleData3 = new MeetingSchedule();
        meetingScheduleData3.readFile("C:\\BCIT\\COMP3760\\lab7\\data3.txt");

        ArrayList<Meeting> sortedByStartTimeData3 = meetingScheduleData3.rankedByStartTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#1(rank by Start)", sortedByStartTimeData3.size());
        System.out.println();
        for (Meeting meeting : sortedByStartTimeData3
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByDurationData3 = meetingScheduleData3.rankedByDuration();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#2(rank by Length)", sortedByDurationData3.size());
        System.out.println();
        for (Meeting meeting : sortedByDurationData3
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByEndTimeData3 = meetingScheduleData3.rankedByEndTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#3(rank by End)", sortedByEndTimeData3.size());
        System.out.println();
        for (Meeting meeting : sortedByEndTimeData3
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        /**
         * data4.txt
         * */
        MeetingSchedule meetingScheduleData4 = new MeetingSchedule();
        meetingScheduleData4.readFile("C:\\BCIT\\COMP3760\\lab7\\data4.txt");

        ArrayList<Meeting> sortedByStartTimeData4 = meetingScheduleData4.rankedByStartTime();

        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#1(rank by Start)", sortedByStartTimeData4.size());
        System.out.println();
        for (Meeting meeting : sortedByStartTimeData4
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByDurationData4 = meetingScheduleData4.rankedByDuration();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#2(rank by Length)", sortedByDurationData4.size());
        System.out.println();
        for (Meeting meeting : sortedByDurationData4
        ) {
            System.out.println(meeting.name);
        }
        System.out.println();

        ArrayList<Meeting> sortedByEndTimeData4 = meetingScheduleData4.rankedByEndTime();
        System.out.printf("There are %d meetings scheduled with Greedy Algorithm#3(rank by End)", sortedByEndTimeData4.size());
        System.out.println();
        for (Meeting meeting : sortedByEndTimeData4
        ) {
            System.out.println(meeting.name);
        }
    }
}

/**
 * <p>
 * Meeting represents a meeting
 * </p>
 */
class Meeting {
    String name;
    int start;
    int end;

    public Meeting(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDuration() {
        return end - start;
    }

    /*
     * This was helpful while I was testing/debugging. It's not needed for any of
     * the official output requirements of the lab.
     */
    public String toString() {
        return name + "[" + start + "," + end + "]";
    }


    /*
     * Check whether this meeting conflicts with another one.
     */
    public boolean overlapsWith(Meeting otherMeeting) {
        return !((start >= otherMeeting.getEnd()) || (otherMeeting.getStart() >= end));
    }
}

/**
 * <p>
 * Compare meetings by starting time
 * </p>
 */
class SortByStartTime implements Comparator<Meeting> {
    /**
     * <p>
     * Compare Meetings by start time
     * </p>
     *
     * @param o1, Meeting to be compared
     * @param o2, scheduled Meeting
     * @return -1 if the start time of o1 is less than that of o2, 0 if they are equal, otherwise return -1
     */
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.getStart() < o2.getStart()) {
            return -1;
        } else if (o1.getStart() == o2.getStart()) {
            return 0;
        } else {
            return 1;
        }
    }
}

/**
 * <p>
 * Compare meetings by meeting duration
 * </p>
 */
class SortByDuration implements Comparator<Meeting> {
    /**
     * <p>
     * Compare Meetings by meeting duration
     * </p>
     *
     * @param o1, Meeting to be compared
     * @param o2, scheduled Meeting
     * @return -1 if the meeting duration of o1 is less than that of o2, 0 if they are equal, otherwise return -1
     */
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.getDuration() < o2.getDuration()) {
            return -1;
        } else if (o1.getDuration() == o2.getDuration()) {
            return 0;
        } else {
            return 1;
        }
    }
}

/**
 * <p>
 * Compare meetings by meeting duration
 * </p>
 */
class SortByEndTime implements Comparator<Meeting> {
    /**
     * <p>
     * Compare Meetings by meeting end time
     * </p>
     *
     * @param o1, Meeting to be compared
     * @param o2, scheduled Meeting
     * @return -1 if the meeting end time of o1 is less than that of o2, 0 if they are equal, otherwise return -1
     */
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.getEnd() < o2.getEnd()) {
            return -1;
        } else if (o1.getEnd() == o2.getEnd()) {
            return 0;
        } else {
            return 1;
        }
    }
}
