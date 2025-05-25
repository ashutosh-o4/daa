import java.util.*;

class Item {
    int index;
    double weight, value;

    public Item(int index, double weight, double value) {
        this.index = index;
        this.weight = weight;
        this.value = value;
    }

    public double valuePerWeight() {
        return value / weight;
    }
}

public class week92 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] weights = new double[n];
        double[] values = new double[n];

        System.out.print("Enter " + n + " space-separated weights: ");
        for (int i = 0; i < n; i++) weights[i] = sc.nextDouble();

        System.out.print("Enter " + n + " space-separated values: ");
        for (int i = 0; i < n; i++) values[i] = sc.nextDouble();

        System.out.print("Enter knapsack capacity: ");
        double capacity = sc.nextDouble();

        // List of items
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(i + 1, weights[i], values[i]));
        }

        // Sort by value/weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.valuePerWeight(), a.valuePerWeight()));

        double totalValue = 0;
        double[] fractions = new double[n]; // Store selected fraction for each item

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                // Take full item
                capacity -= item.weight;
                totalValue += item.value;
                fractions[item.index - 1] = 1;
            } else {
                // Take fraction
                double fraction = capacity / item.weight;
                totalValue += item.value * fraction;
                fractions[item.index - 1] = fraction;
                capacity = 0;
            }
        }

        // Output
        System.out.println("\nMaximum value achieved: " + totalValue);
        System.out.println("Items selected with their fraction:");

        for (int i = 0; i < n; i++) {
            if (fractions[i] > 0) {
                System.out.printf("Item %d -> %.2f fraction\n", i + 1, fractions[i]);
            }
        }

        sc.close();
    }
}
