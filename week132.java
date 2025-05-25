import java.util.*;

public class week132 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine()); // Number of test cases
        
        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine()); // Array size
            
            // Read array
            int[] arr = new int[n];
            String[] parts = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(parts[i]);
            
            int k = Integer.parseInt(sc.nextLine()); // Window size
            
            if (containsDuplicateInWindow(arr, n, k)) {
                System.out.println("Duplicate present in window k");
            } else {
                System.out.println("Duplicate not present in window k");
            }
        }
        sc.close();
    }

    // Function to check for duplicates in any window of size k
    private static boolean containsDuplicateInWindow(int[] arr, int n, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (window.contains(arr[i])) {
                return true; // Duplicate found
            }

            window.add(arr[i]);

            // Maintain window size <= k
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }
        return false;
    }
}