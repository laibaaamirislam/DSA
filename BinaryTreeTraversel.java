class BinaryTreeTraversal {

    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;
    public BinaryTreeTraversal() {
        root = null;
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 38);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 90);

        System.out.print("Pre-order Traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("In-order Traversal: ");
        tree.inOrder(tree.root);
        System.out.println();


        System.out.print("Post-order Traversal: ");
        tree.postOrder(tree.root);
        System.out.println();
    }
}
