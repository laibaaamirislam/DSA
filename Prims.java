import java.util.ArrayList;
import java.util.List;

public class Prims {

    public class Node {
        int value;
        int weight;
        Node next;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.next = null;
        }
    }

    public class PriorityQueueWithArrayList {
        Node head;
        int size = 0;

        public PriorityQueueWithArrayList() {
            head = null;
        }

        public void enqueue(Node node) {
            if (head == null || head.weight > node.weight) {
                node.next = head;
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null && temp.next.weight <= node.weight) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
            size++;
        }

        public Node dequeue() {
            if (isEmpty()) return null;
            Node node = head;
            head = head.next;
            size--;
            return node;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public void prims(List<List<int[]>> graph, int start) {
        PriorityQueueWithArrayList pq = new PriorityQueueWithArrayList();
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        int[] distance = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;
        pq.enqueue(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.dequeue();
            int u = current.value;

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (!visited[v] && weight < distance[v]) {
                    distance[v] = weight;
                    parent[v] = u;
                    pq.enqueue(new Node(v, weight));
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

