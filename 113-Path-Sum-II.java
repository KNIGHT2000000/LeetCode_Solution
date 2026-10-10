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
    public void helper_fx(TreeNode node,List<List<Integer>> res,List<Integer> r,int targetSum){
        // here we will try to 
        if (node == null) {
            return;
        }
        //
        r.add(node.val);
        targetSum-=node.val;

if (node.left == null && node.right == null && targetSum == 0) 
{
            // Important: add a NEW copy of the currentPath, otherwise it will get mutated/cleared later
            res.add(new ArrayList<>(r));
}
else{
    helper_fx(node.left,res,r,targetSum);
    helper_fx(node.right,res,r,targetSum);
}

r.remove(r.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // we have to cretae a list
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> r= new ArrayList<>();
        helper_fx(root,res,r,targetSum);
        return res;

      
       


    
    }
}