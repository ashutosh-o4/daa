import java.util.*;

public class week131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        // Input characters
        System.out.println("Enter the characters:");
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Sort keys alphabetically
        List<Character> keys = new ArrayList<>(freqMap.keySet());
        Collections.sort(keys);

        // Output
        System.out.println("Distinct characters in alphabetical order:");
        for (char ch : keys) {
            System.out.println(ch + " -> " + freqMap.get(ch));
        }

        sc.close();
    }
}