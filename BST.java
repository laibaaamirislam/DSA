
public class BST {
    class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    Node root;

    public BST(Node root) {
        this.root = root;
    }


    public Node search(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }
        if (key < root.value) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }


        if (val < root.value) {
            root.left = insert(root.left, val);
        } else if (val > root.value) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node successor = getSuccessor(root);
            root.value = successor.value;


            root.right = delete(root.right, successor.value);
        }
        return root;
    }


    public Node getSuccessor(Node node) {
        Node curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}

