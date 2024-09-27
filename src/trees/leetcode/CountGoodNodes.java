package trees.leetcode;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 * Example 1
 * Input: root = [3,1,4,3,null,1,5]
 *        3
 *      /   \
 *     1     4
 *    /     / \
 *   3     1   5
 *
 * Output: 4
 * Explanation:
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 */
public class CountGoodNodes {

    int count = 0;

    public void countGoodNodes(TreeNode root, int maximum) {
        if(root!=null) {
            if (maximum <= root.val) {
                maximum = root.val;
                count++;
            }
            countGoodNodes(root.left,maximum);
            countGoodNodes(root.right, maximum);
        }
    }

    public int goodNodes(TreeNode root) {
        int maximum = root.val;
        countGoodNodes(root,  maximum);
        return count;
    }



}
