import java.util.*;

public class week122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++)
            weights[i] = sc.nextInt();

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++)
            values[i] = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        // dp[i][j] = max value using first i items with capacity j
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Backtrack to find selected items
        List<Integer> selectedWeights = new ArrayList<>();
        List<Integer> selectedValues = new ArrayList<>();
        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedWeights.add(weights[i - 1]);
                selectedValues.add(values[i - 1]);
                w -= weights[i - 1];
            }
        }

        // Output
        System.out.println("Maximum value = " + dp[n][W]);
        System.out.print("Weights selected: ");
        for (int wt : selectedWeights)
            System.out.print(wt + " ");
        System.out.println();

        System.out.print("Values of selected weights: ");
        for (int val : selectedValues)
            System.out.print(val + " ");
        System.out.println();

        sc.close();
    }
}