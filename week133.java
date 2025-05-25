import java.util.*;

public class week133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input size
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Map to store product -> pair of indices
        Map<Integer, int[]> productMap = new HashMap<>();
        boolean found = false;

        // Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = arr[i] * arr[j];

                if (!productMap.containsKey(product)) {
                    productMap.put(product, new int[]{i, j});
                } else {
                    int[] prev = productMap.get(product);
                    // Ensure all indices are distinct
                    if (prev[0] != i && prev[0] != j && prev[1] != i && prev[1] != j) {
                        System.out.println("Pair (a,b): (" + arr[prev[0]] + ", " + arr[prev[1]] + ")");
                        System.out.println("Pair (c,d): (" + arr[i] + ", " + arr[j] + ")");
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("No such pairs found.");
        }

        sc.close();
    }
}