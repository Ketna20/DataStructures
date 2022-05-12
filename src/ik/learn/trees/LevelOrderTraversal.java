package ik.learn.trees;
/*
 * ketnakhalasi created on 5/2/22
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
//        BinaryTreeNode root = new BinaryTreeNode(3);
//        root.left = new BinaryTreeNode(9);
//        root.right = new BinaryTreeNode(20);
//        BinaryTreeNode prev = root;
//        root = root.left;
//        root.left = new BinaryTreeNode(10);
//        root.right = new BinaryTreeNode(12);
//        prev.left = new BinaryTreeNode(15);
//        prev.right = new BinaryTreeNode(7);

//        inorder(prev);
//        ArrayList<ArrayList<Integer>> nodes = level_order_traversal(prev);
//        for (int i=0; i<nodes.size(); i++) {
//            System.out.println(nodes.get(i));
//        }


    }
    static void inorder(BinaryTreeNode root){
        if(root ==null) return;

        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);

    }
    //working function code
    static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;

        Queue<BinaryTreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);

        while(!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                BinaryTreeNode node = nodeQ.remove();
                list.add(node.value);

                //add children
                if(node.left != null)
                    nodeQ.add(node.left);
                if(node.right != null)
                    nodeQ.add(node.right);
            }
            result.add(list);
        }

        return result;
    }
}

class BinaryTreeNode {
    Integer value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
