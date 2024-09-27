package trees.leetcode;

public class BinarySubTree {

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null || isSameTree(root, subRoot)){
            return true;
        }
        if(root == null) return false;

        return isSubTree(root.left, subRoot) && isSubTree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q != null && p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
