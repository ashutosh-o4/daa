import java.util.Scanner;

public class week141 {

    // Function to return nth ugly number
    public static int getNthUglyNumber(int n) {
        int[] ugly = new int[n]; // To store ugly numbers
        ugly[0] = 1; // First ugly number is 1

        int i2 = 0, i3 = 0, i5 = 0; // Indexes for multiples
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            if (nextUgly == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.print("Enter n: ");
            int n = sc.nextInt();
            int result = getNthUglyNumber(n);
            System.out.println("The " + n + "th ugly number is: " + result);
        }
    }
}
