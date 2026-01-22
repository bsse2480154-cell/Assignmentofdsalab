//Question no 6
class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    // Insert into BST
    static BSTNode insert(BSTNode root, int val) {
        if (root == null) return new BSTNode(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Traversals
    static void inorder(BSTNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    static void preorder(BSTNode root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(BSTNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // Search
    static boolean search(BSTNode root, int val) {
        if (root == null) return false;
        if (root.data == val) return true;

        if (val < root.data) return search(root.left, val);
        else return search(root.right, val);
    }

    // Delete using inorder successor
    static BSTNode delete(BSTNode root, int val) {
        if (root == null) return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BSTNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }

        return root;
    }

    // Recursive min/max
    static int findMin(BSTNode root) {
        if (root.left == null) return root.data;
        return findMin(root.left);
    }

    static int findMax(BSTNode root) {
        if (root.right == null) return root.data;
        return findMax(root.right);
    }

    // Count total nodes
    static int countNodes(BSTNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Count leaf nodes
    static int countLeafNodes(BSTNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // Height
    static int height(BSTNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BSTNode root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) root = insert(root, val);

        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println();
        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println();
        System.out.println("Postorder traversal:");
        postorder(root);
        System.out.println();
        System.out.println("Search for 60: " + search(root, 60));

        root = delete(root, 80);
        System.out.println("After deleting 80,Inorder traversal:");
        inorder(root);
        System.out.println();
        System.out.println("Minimum value in BST: " + findMin(root));
        System.out.println("Maximum value in BST: " + findMax(root));

        System.out.println("Total nodes in BST: " + countNodes(root));
        System.out.println("Leaf nodes in BST: " + countLeafNodes(root));
        System.out.println("Height of BST: " + height(root));
    }
}
