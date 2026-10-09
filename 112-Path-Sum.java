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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // find a path where we get sum 
   
        // of that path == to the given target 
        if(root==null){
            return false;
        }
  targetSum-=root.val;
        if(root.left==null && root.right==null){
            //leaf node 
            if(targetSum==0){
                return true;
            }
        }
      return hasPathSum(root.left, targetSum)
            || hasPathSum(root.right, targetSum);

        //

    }
}