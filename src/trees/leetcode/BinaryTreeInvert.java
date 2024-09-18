package trees.leetcode;

/**
 * Leetcode: 226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 *        4                         4
 *      /   \                     /   \
 *     2      7     ---->        7      2
 *    / \    / \                / \    / \
 *   1   3  6   9              9   6  3   1
 */
public class BinaryTreeInvert {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null) {
            invertTree(root.left);
        }

        if(root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }
}
