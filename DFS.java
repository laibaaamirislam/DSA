import java.util.Queue;
import java.util.Stack;

public class DFS {
    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node node;

        public void DFS(Node root){
            Stack<Node> stack=new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node node=stack.pop();
                System.out.println(node.value);
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }

        }

}
