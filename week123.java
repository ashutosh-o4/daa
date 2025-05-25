import java.util.*;

public class week123 {
    static void permute(char[] str, int l, int r, List<String> result) {
        if (l == r) {
            result.add(new String(str));
        } else {
            for (int i = l; i <= r; i++) {
                if (shouldSwap(str, l, i)) {
                    swap(str, l, i);
                    permute(str, l + 1, r, result);
                    swap(str, l, i); // backtrack
                }
            }
        }
    }

    // Helper to check if swapping will result in a duplicate permutation
    static boolean shouldSwap(char[] str, int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr])
                return false;
        }
        return true;
    }

    static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        char[] chars = input.toCharArray();
        Arrays.sort(chars);  // Ensure lexicographic order

        List<String> result = new ArrayList<>();
        permute(chars, 0, chars.length - 1, result);

        Collections.sort(result);  // Ensure final order if needed
        System.out.println("Lexicographic permutations:");
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}