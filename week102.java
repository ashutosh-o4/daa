import java.util.*;

public class week102 {

    static class Task {
        int index;
        int time;
        int deadline;

        Task(int index, int time, int deadline) {
            this.index = index;
            this.time = time;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        int[] time = new int[n];
        int[] deadline = new int[n];

        System.out.print("Enter time for each task: ");
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }

        System.out.print("Enter deadline for each task: ");
        for (int i = 0; i < n; i++) {
            deadline[i] = sc.nextInt();
        }

        // Prepare tasks
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(i + 1, time[i], deadline[i]));
        }

        // Sort by deadline
        tasks.sort(Comparator.comparingInt(t -> t.deadline));

        // Min-Heap based on task time
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        int currentTime = 0;

        for (Task task : tasks) {
            if (currentTime + task.time <= task.deadline) {
                maxHeap.add(task);
                currentTime += task.time;
            } else if (!maxHeap.isEmpty() && maxHeap.peek().time > task.time) {
                Task removed = maxHeap.poll();
                currentTime -= removed.time;
                maxHeap.add(task);
                currentTime += task.time;
            }
        }

        // Output
        System.out.println("\nMaximum number of tasks that can be completed: " + maxHeap.size());
        System.out.print("Selected tasks (by index): ");
        List<Integer> result = new ArrayList<>();
        for (Task t : maxHeap) {
            result.add(t.index);
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) System.out.print(", ");
        }
    }
}
