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
    public void helpe4r(TreeNode root,List<Integer> li){
     
        if(root == null){
            return;
        }
        // if(root.left== null && root.right ==null){
        //    traverse.add(root.val);
        // }
        helpe4r(root.left,li);
        li.add(root.val);
        helpe4r(root.right,li);
       
    }

    
    public List<Integer> inorderTraversal(TreeNode root) {
             List<Integer> traverse =new ArrayList<>();

             helpe4r(root,traverse);
             return traverse;
    }
      
}