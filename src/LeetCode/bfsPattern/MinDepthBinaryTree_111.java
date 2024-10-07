package LeetCode.bfsPattern;
import trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class MinDepthBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            for(int i=0; i< levelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(node.left == null && node.right == null)
                    return level; //the very first leaf will be encountered in BFS.
            }
            level++;
        }
        return level;
    }
}
