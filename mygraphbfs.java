import java.util.ArrayList;
import java.util.List;

public class mygraphbfs {

    class QueueWithArrayList {
        private ArrayList<Integer> queue;

        public QueueWithArrayList() {
            queue = new ArrayList<>();
        }

        public void enqueue(int item) {
            queue.add(item);
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty!");
            }
            return queue.remove(0);
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty!");
            }
            return queue.get(0);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public int size() {
            return queue.size();
        }
    }

    QueueWithArrayList queue;

    public mygraphbfs() {
        queue=new QueueWithArrayList();
    }

    public void BFS(List<List<Integer>> adjacencyList, int start){

        boolean[] visited=new boolean[adjacencyList.size()];
        visited[start]=true;
         queue.enqueue(start);

         while(!queue.isEmpty()){
             int current= queue.dequeue();
             System.out.print(current + " ");
             for (int x : adjacencyList.get(current)) {
                 if (!visited[x]) {
                     visited[x] = true;
                     queue.enqueue(x);
                 }
             }
         }

    }

    public void DFS(List<List<Integer>> adjacencyList, int start){
        boolean [] visited=new boolean[adjacencyList.size()];
        recDfs(adjacencyList,visited,start);
    }
    public void recDfs(List<List<Integer>> adjacencyList,boolean[] visited, int start){
        visited[start]=true;
        System.out.println(start+"");
        for(int x:adjacencyList.get(start)){
            if(!visited[x]){
                recDfs(adjacencyList,visited,x);
            }
        }
    }


    static void addAdjacentNeighbour(List<List<Integer>> adjList, int nodeA, int nodeB){
        adjList.get(nodeA).add(nodeB);
        adjList.get(nodeB).add(nodeA);


    }

    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };

        for (int[] e : edges) {
            addAdjacentNeighbour(adj, e[0], e[1]);
        }

        mygraphbfs graph=new mygraphbfs();

// BFS
        System.out.println("BFS starting from 0:");
        graph.BFS(adj,0);

// DFS
        int start = 1;
        System.out.println("DFS starting from " + start+ ":");
        graph.DFS(adj, start);
    }


}
