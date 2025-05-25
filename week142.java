import java.util.*;

public class week142 {

    // DFS utility function
    static void dfs(List<List<Integer>> graph, boolean[] visited, int v) {
        visited[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    // Function to find mother vertex
    public static int findMotherVertex(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        int lastFinished = 0;

        // Step 1: Find the last finished vertex in DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                lastFinished = i;
            }
        }

        // Step 2: Check if last finished vertex is indeed a mother vertex
        Arrays.fill(visited, false);
        dfs(graph, visited, lastFinished);

        for (boolean v : visited) {
            if (!v) {
                return -1; // No mother vertex
            }
        }

        return lastFinished;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        // Input: Adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (from to): ");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        int motherVertex = findMotherVertex(graph, V);
        if (motherVertex == -1)
            System.out.println("No Mother Vertex Found");
        else
            System.out.println("Mother Vertex is: " + motherVertex);
    }
}
