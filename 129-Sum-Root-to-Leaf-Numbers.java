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
    public void helper_fx(TreeNode node,List<Integer> digits,int curr){
        // here we will populaate all the digits formed from root to leabes 
        if(node==null){
            return;
        }
        // i have to figure out logic where we can 
        curr=curr*10+node.val;

        if(node.left==null && node.right == null){
            digits.add(curr);
        }
        //
        else{helper_fx(node.left,digits,curr);

        helper_fx(node.right,digits,curr);
        }
curr=curr/10;

    }

    
    public int sumNumbers(TreeNode root) {
        // this is also classic case of backtracking
        // here also we need to work upon the backtracking logic
      List<Integer> digits=new ArrayList<>();
      int curr=0;
      int sum=0;
      helper_fx(root,digits,curr);
      for(int i=0;i<digits.size();i++) {
              sum=sum+digits.get(i);
    }
    return sum;

}}