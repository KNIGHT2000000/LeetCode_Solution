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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        // we have to find the minimum depth 
        // solve this as base to the pattern
        Queue<TreeNode> q=new LinkedList<>();
        // a queue is made for bfs
        q.offer(root);
        //root is offered to it and then
        int count=0;
        while(!q.isEmpty()){
            // queue is empty
            int size=q.size();
            //size of queue
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
               if(node.left==null && node.right==null){
                return count+1;
               }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            count++;
        }
      return -1;
    }
}