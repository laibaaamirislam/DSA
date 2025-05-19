import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static class Node implements Comparable<Node> {
        int value;
        int priority;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    public void addEdge(List<List<int[]>> graph, int u, int v, int weight) {
        graph.get(u).add(new int[] { v, weight });
    }

    public void dijkstra(List<List<int[]>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.size()];
        int[] parent = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.value;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(" " + i + " Distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        List<List<int[]>> adj = new ArrayList<>();

        int n = 7; // Update the number of nodes
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        dijkstra.addEdge(adj, 0, 1, 2);
        dijkstra.addEdge(adj, 0, 3, 7);
        dijkstra.addEdge(adj, 0, 4, 12);
        dijkstra.addEdge(adj, 1, 3, 2);
        dijkstra.addEdge(adj, 2, 1, 3);
        dijkstra.addEdge(adj, 2, 3, 1);
        dijkstra.addEdge(adj, 2, 4, 2);
        dijkstra.addEdge(adj, 3, 5, 2);
        dijkstra.addEdge(adj, 5, 6, 2);
        dijkstra.addEdge(adj, 6, 3, 1);

        dijkstra.dijkstra(adj, 0);
    }
}
