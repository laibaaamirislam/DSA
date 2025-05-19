import java.util.LinkedList;
import java.util.Queue;

class BSTBFS {
    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    public BSTBFS() {
        root = null;
    }

    public void bfs(Node root) {
        if (root == null) {
            return;
        }


        Queue<Node> queue = new LinkedList<>();


        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }}