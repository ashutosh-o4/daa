import java.util.*;

public class week112{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of coins
        System.out.print("Enter number of coins: ");
        int numCoins = sc.nextInt();

        int[] coins = new int[numCoins];
        System.out.print("Enter coin values: ");
        for (int i = 0; i < numCoins; i++) {
            coins[i] = sc.nextInt();
        }

        // Input the target value
        System.out.print("Enter the value N: ");
        int target = sc.nextInt();

        // Get number of ways
        int result = countWays(coins, target);
        System.out.println("Number of ways: " + result);
    }

    public static int countWays(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[target];
    }
}
