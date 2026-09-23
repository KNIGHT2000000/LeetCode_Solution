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
    public int maxDepth(TreeNode root) {
      
        // we have to traverse till max depth and then 
        if(root==null){
            return 0;
        }
        int res_left=maxDepth(root.left);
        int res_right=maxDepth(root.right);



                        //agar root null ho to stop 

        // we need to find max depth and the best ways we can apply is recursion 



        return 1+Math.max(res_left,res_right);
    }
    
}