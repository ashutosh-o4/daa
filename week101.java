import java.util.*;

public class week101 {

    static class Activity {
        int index;
        int start;
        int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        System.out.print("Enter start times: ");
        for (int i = 0; i < n; i++) startTimes[i] = sc.nextInt();

        System.out.print("Enter end times: ");
        for (int i = 0; i < n; i++) endTimes[i] = sc.nextInt();

        // Create a list of activities
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(i + 1, startTimes[i], endTimes[i]));
        }

        // Sort activities by end time
        activities.sort(Comparator.comparingInt(a -> a.end));

        List<Integer> selected = new ArrayList<>();
        int lastEnd = 0;

        for (Activity activity : activities) {
            if (activity.start >= lastEnd) {
                selected.add(activity.index);
                lastEnd = activity.end;
            }
        }

        // Output
        System.out.println("\nNo. of non-conflicting activities: " + selected.size());
        System.out.print("List of selected activities: ");
        for (int i = 0; i < selected.size(); i++) {
            System.out.print(selected.get(i));
            if (i != selected.size() - 1) System.out.print(", ");
        }
    }
}
