import java.util.*;

public class week93 {

    public static int minMergeCost(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all file sizes to min heap
        for (int size : files) {
            pq.add(size);
        }

        int totalCost = 0;

        // Keep merging two smallest files
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int mergeCost = first + second;
            totalCost += mergeCost;

            pq.add(mergeCost); // Add merged file back
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        // Input array
        int[] files = new int[n];
        System.out.print("Enter file sizes: ");
        for (int i = 0; i < n; i++) {
            files[i] = sc.nextInt();
        }

        // Output result
        int result = minMergeCost(files);
        System.out.println("Minimum computation cost to merge files: " + result);
    }
}
