public class BST {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; left = right = null; }
    }

    Node root;

    Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }

    int findMin(Node root) {
        while (root.left != null) root = root.left;
        return root.data;
    }

    int findMax(Node root) {
        while (root.right != null) root = root.right;
        return root.data;
    }

    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    Node delete(Node root, int key) {
        if (root == null) return null;
        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] elements = {50, 30, 70, 20, 40, 60, 80};
        for (int el : elements) tree.root = tree.insert(tree.root, el);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Search 60: " + (tree.search(tree.root, 60) ? "Found" : "Not Found"));

        tree.root = tree.delete(tree.root, 80);
        System.out.print("Inorder after deleting 80: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Minimum value: " + tree.findMin(tree.root));
        System.out.println("Maximum value: " + tree.findMax(tree.root));

        System.out.println("Total nodes: " + tree.countNodes(tree.root));
        System.out.println("Leaf nodes: " + tree.countLeaves(tree.root));
        System.out.println("Tree height: " + tree.height(tree.root));
    }
}
