public class AVL {
    class NodeA {
        int value, height;
        NodeA left, right;

        public NodeA(int value) {
            this.value = value;
            height = 1;
            left = null;
            right = null;
        }
    }

    NodeA root;

    public AVL() {
        root = null;
    }

    public int height(NodeA node) {
        return node == null ? 0 : node.height;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int getBalance(NodeA node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public NodeA rotateRight(NodeA z) {
        NodeA y = z.left;
        NodeA temp = y.right;
        y.right = z;
        z.left = temp;

        z.height = max(height(z.left), height(z.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public NodeA rotateLeft(NodeA z) {
        NodeA y = z.right;
        NodeA temp = y.left;
        y.left = z;
        z.right = temp;

        z.height = max(height(z.left), height(z.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public NodeA insert(NodeA node, int key) {
        if (node == null) {
            return new NodeA(key);
        }

        if (key < node.value) {
            node.left = insert(node.left, key);
        } else if (key > node.value) {
            node.right = insert(node.right, key);
        } else {
            node.height = max(height(node.left), height(node.right)) + 1;
            return node;
        }

        node.height = max(height(node.left), height(node.right)) + 1;
        int balanced = getBalance(node);

        if (balanced > 1 && key < node.left.value) {
            return rotateRight(node);
        } else if (balanced < -1 && key > node.right.value) {
            return rotateLeft(node);
        } else if (balanced > 1 && key > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balanced < -1 && key < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public NodeA delete(NodeA root, int key) {
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

            NodeA successor = getSuccessor(root);
            root.value = successor.value;
            root.right = delete(root.right, successor.value);
        }

        root.height = max(height(root.left), height(root.right)) + 1;
        int balanced = getBalance(root);

        if (balanced > 1) {
            if (getBalance(root.left) >= 0) {
                return rotateRight(root);
            } else {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        } else if (balanced < -1) {
            if (getBalance(root.right) <= 0) {
                return rotateLeft(root);
            } else {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    public NodeA getSuccessor(NodeA node) {
        NodeA curr = node.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    void preOrder(NodeA node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of the AVL tree is:");
        tree.preOrder(tree.root);

        tree.root = tree.delete(tree.root, 30);
        System.out.println("\nPreorder traversal after deletion:");
        tree.preOrder(tree.root);
    }
}
