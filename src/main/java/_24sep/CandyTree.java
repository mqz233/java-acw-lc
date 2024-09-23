package _24sep;

import java.util.*;
import java.util.*;

public class CandyTree {
    static class Edge {
        int to;
        Edge(int to) {
            this.to = to;
        }
    }

    static List<List<Edge>> adjList;
    static int[] colors;
    static int n;
    static int maxXorSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        adjList = new ArrayList<>();
        colors = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read colors
        for (int i = 1; i <= n; i++) {
            colors[i] = scanner.nextInt();
        }

        // Build the tree
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt();
            adjList.get(u).add(new Edge(v));
            adjList.get(v).add(new Edge(u));
        }

        // Calculate the maximum XOR sum
        dfs(1, -1);

        System.out.println(maxXorSum);
    }

    private static int dfs(int node, int parent) {
        Map<Integer, Integer> colorCount = new HashMap<>();

        // Count the color of current node
        colorCount.put(colors[node], colorCount.getOrDefault(colors[node], 0) + 1);

        // Process children
        int maxXor = 0;
        for (Edge edge : adjList.get(node)) {
            if (edge.to != parent) {
                int childXor = dfs(edge.to, node);
                maxXor = Math.max(maxXor, childXor);
            }
        }

        // Calculate XOR sum after removing the most frequent color(s)
        int xorSum = calculateXorAfterRemovingMostFrequent(colorCount);

        maxXorSum = Math.max(maxXorSum, xorSum);
        return xorSum;
    }

    private static int calculateXorAfterRemovingMostFrequent(Map<Integer, Integer> colorCount) {
        int maxFrequency = colorCount.values().stream().max(Integer::compare).orElse(0);
        int xorSum = 0;

        for (Map.Entry<Integer, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() < maxFrequency) {
                xorSum ^= entry.getKey();
            }
        }

        return xorSum;
    }
}