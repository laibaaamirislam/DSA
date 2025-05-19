import java.util.*;

class Edge {
    int source, destination, weight;

    public int getWeight() {
        return weight;
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;


    }
}

class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class Kruskal {
    public static void kruskalMST(int n, List<Edge> edges) {
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));


        DisjointSet ds = new DisjointSet(n);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;

            if (ds.find(u) != ds.find(v)) {
                mst.add(edge);
                ds.union(u, v);
            }
        }

        int mstWeight = 0;
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
            mstWeight += edge.weight;
        }
        System.out.println("Weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int n = 4;
        kruskalMST(n, edges);
    }
}

