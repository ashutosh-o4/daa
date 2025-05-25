import java.util.*;

public class  week111 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of matrices
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        // Matrix dimensions input
        int[] p = new int[n + 1]; // dimension array of size n+1

        System.out.println("Enter dimensions of matrices (rows and columns):");
        for (int i = 0; i < n; i++) {
            System.out.print("Matrix " + (i + 1) + " rows: ");
            p[i] = sc.nextInt();
            System.out.print("Matrix " + (i + 1) + " columns: ");
            int col = sc.nextInt();
            if (i == n - 1) {
                p[n] = col;
            } else if (col != p[i + 1]) {
                // Optional: check for consistent matrix chaining
                // Matrices must be compatible for multiplication
            }
        }

        // Calculate minimum operations using DP
        int minCost = matrixChainOrder(p, n);
        System.out.println("Minimum number of multiplications: " + minCost);
    }

    // Dynamic Programming function
    public static int matrixChainOrder(int[] p, int n) {
        int[][] m = new int[n][n];

        // m[i][i] = 0 (single matrix multiplication cost is 0)
        for (int L = 2; L <= n; L++) { // chain length
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[0][n - 1];
    }
}
