import java.util.*;

public class Prims2 {

    public static class Edge {
        int value;
        int weight;

        public Edge(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public void prims2(List<List<int[]>> graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        int[] distance = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.value;

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (!visited[v] && weight < distance[v]) {
                    distance[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, weight));
                }
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (int i = 0; i < graph.size(); i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + " (Weight: " + distance[i] + ")");
            }
        }
    }

    public void addEdge(List<List<int[]>> graph, int u, int v, int weight) {
        graph.get(u).add(new int[] { v, weight });
        graph.get(v).add(new int[] { u, weight });
    }

    public static void main(String[] args) {
        Prims prims = new Prims();
        List<List<int[]>> adj = new ArrayList<>();

        int n = 5;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        prims.addEdge(adj, 0, 1, 2);
        prims.addEdge(adj, 0, 2, 4);
        prims.addEdge(adj, 1, 2, 1);
        prims.addEdge(adj, 1, 3, 7);
        prims.addEdge(adj, 2, 4, 3);

        prims.prims(adj, 0);
    }
}
