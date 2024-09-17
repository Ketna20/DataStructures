package trees.leetcode;

/**
 * Leetcode: 101
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *        7
 *      /   \
 *     2      2
 *    / \    / \
 *   3   4  3   4
 */
public class SymmetricTree {

    public static void main(String[] args)
    {
        // Create a symmetric binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4); // for symmetric tree
//        root.left.right = new TreeNode(5); // for asymmetric tree
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Check if the tree is symmetric

        if (new SymmetricTree().isSymmetric(root)) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }


}
