import java.util.*;

public class week103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. Find Majority Element
        int candidate = findCandidate(arr);
        boolean isMajority = checkMajority(arr, candidate);

        System.out.println(isMajority ? "yes" : "no");

        // 2. Find Median
        Arrays.sort(arr);
        double median;
        if (n % 2 == 1) {
            median = arr[n / 2];
        } else {
            median = (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }

        System.out.println("Median of the array: " + median);
    }

    // Function to find majority candidate
    private static int findCandidate(int[] arr) {
        int count = 0, candidate = -1;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // Function to verify if candidate is majority
    private static boolean checkMajority(int[] arr, int candidate) {
        int count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        return count > arr.length / 2;
    }
}
