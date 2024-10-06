package LeetCode.bfsPattern;

import trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            long sum = 0;
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for(int i=0; i<levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            double avg = (double) sum/levelSize;
            res.add(avg);
        }

        return res;
    }
}
