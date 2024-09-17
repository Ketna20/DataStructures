package trees.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 94 Binary Tree Inorder Traversal
 */
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseInOrder(root, res);
        return res;
    }

    public void traverseInOrder(TreeNode node, List<Integer> res) {
        if(node!= null) {
            traverseInOrder(node.left, res);
            res.add(node.val);
            traverseInOrder(node.right, res);
        }
    }
}
