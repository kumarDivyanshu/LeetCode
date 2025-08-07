import java.util.*;

class Pair {
    int to;
    int cost;

    Pair(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Build graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int minReachable = n + 1;
        int resultCity = -1;

        for (int src = 0; src < n; src++) {
            // Dijkstra from src
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            pq.offer(new Pair(src, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int u = current.to;
                int cost = current.cost;

                for (Pair neighbor : graph.get(u)) {
                    int v = neighbor.to;
                    int newCost = cost + neighbor.cost;
                    if (newCost < dist[v]) {
                        dist[v] = newCost;
                        pq.offer(new Pair(v, newCost));
                    }
                }
            }

            // Count reachable cities
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i != src && dist[i] <= distanceThreshold) {
                    count++;
                }
            }

            // Update result based on problem requirement
            if (count <= minReachable) {
                minReachable = count;
                resultCity = src; // pick larger index in case of tie
            }
        }

        return resultCity;
    }
}
