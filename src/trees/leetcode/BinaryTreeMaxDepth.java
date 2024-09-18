package trees.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode: 104 Maximum Depth of Binary Tree
 */
public class BinaryTreeMaxDepth {

    public int maxDepthUsingLevelOrder(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i=0; i< length; i++) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                queue.poll();
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

}
