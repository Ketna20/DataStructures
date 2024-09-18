package trees.leetcode;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertNode(int val) {
        root = insertHelper(root, val);
    }

    private TreeNode insertHelper(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val) {
            root.left = insertHelper(root.left, val);
        } else if(val > root.val) {
            root.right = insertHelper(root.right, val);
        }

        return root;
    }

    public TreeNode search(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }
        if(val < root.val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if(root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(20);
        bst.insertNode(40);
        bst.insertNode(70);
        bst.insertNode(60);
        bst.insertNode(80);

        System.out.println("In Order Traversal: ");
        bst.inOrderTraversal(bst.root);
    }
}
