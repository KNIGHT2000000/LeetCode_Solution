/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //     public TreeNode searchsubtree(TreeNode root,TreeNode subRoot,TreeNode n1){

    //         if(root==null){
    //             retrun null;
    //         }
    //         if(root.val==subRoot.val){
    //             n1=root;
    //         }
    //         searchsubtree(root.left,subRoot);
    //         searchsubtree(root.right,subRoot);
    // retrun  n1;

    //     }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // TreeNode n1=null;

        // // we are given two of thr root and we have to go 
        // if(root==null || subRoot== null){
        //     return true;
        // }
        // //here we 
        // n1=searchsubtree(root,subRoot,n1)

        // if(n1==null)
        // {
        //     return false;
        // }

        if (root == null && subRoot == null) {
            return true;

        }
        if (root == null || subRoot == null) {
            return false;

        }
        if (isSameTree(root, subRoot)) {
            return true;
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }
}