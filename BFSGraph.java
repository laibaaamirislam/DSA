
import java.util.*;


class BFSGraph {


    static void bfs(List<List<Integer>> adj, int s) {

        Queue<Integer> q = new LinkedList<>();


        boolean[] visited = new boolean[adj.size()];
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.print(curr + " ");
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }


    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
