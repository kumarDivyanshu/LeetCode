class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;   // stops
        this.second = second; // node
        this.third = third;   // cost
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0)); // stops, node, cost

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int cost = curr.third;

            if (stops > K) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode]) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}