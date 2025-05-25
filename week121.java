import java.util.Scanner;

public class week121 {
    public static String findLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Backtrack to find LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.insert(0, X.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Output
        System.out.println("Longest Common Subsequence: " + lcs.toString());
        System.out.println("Length: " + lcs.length());

        return lcs.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first sequence: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second sequence: ");
        String s2 = sc.nextLine();

        findLCS(s1, s2);
        sc.close();
    }
}