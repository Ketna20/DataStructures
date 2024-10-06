package LeetCode.bfsPattern;

import trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueEachRow_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<levelSize; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(max);
        }

        return result;
    }
}
