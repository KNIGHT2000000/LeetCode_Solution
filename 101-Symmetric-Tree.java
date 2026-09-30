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
    public boolean isSymmetric(TreeNode root) {
        // if(root.left==root.right&&root.right==root.left){
        //     return true;

        // }
        // isSymmetry(root.left);
        // isSymmetry(root.right);
        if(root==null){
            return true;
        }
        else{
                  return  ismirror(root.left,root.right);
        }

       
    }
    public boolean ismirror( TreeNode l, TreeNode r){
        if(l==null && r==null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }
        else{
            return (l.val==r.val)&&ismirror(l.left,r.right)&&ismirror(l.right,r.left);

        }
    }
}