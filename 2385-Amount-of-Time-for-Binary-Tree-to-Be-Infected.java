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
    public TreeNode Node_to_val(TreeNode root,int start){
         if (root == null) return null;
        if (root.val == start) return root;
        
        TreeNode leftResult = Node_to_val(root.left, start);
        if (leftResult != null) return leftResult;
        
        return Node_to_val(root.right, start);
      
    }
    public Map<TreeNode,TreeNode> compute_parents(TreeNode root,Map<TreeNode,TreeNode> map){
        // this function will populate all the very immediate of all the node
        if(root==null){
            return map;
        }
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
            //we dont need levels we just need parents 
            TreeNode n1=q.poll();
            if(n1.right!=null){
                map.put(n1.right,n1);
                q.offer(n1.right);
            }
            if(n1.left!=null){
                map.put(n1.left,n1);
                q.offer(n1.left);
            }

         }
         return map;

    }
    public int amountOfTime(TreeNode root, int start) {
        // all the edge cases 
        if(root==null){
            return 0;
        }
        int min=0;
        Queue<TreeNode> q1 = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode,TreeNode> map=new HashMap<>();
        map=compute_parents(root,map);
        // we need to get starting point

        TreeNode start1=Node_to_val(root,start);
        if (start1 == null) return 0;
        q1.offer(start1);
        visited.add(start1);
        while(!q1.isEmpty())
        {
            int size=q1.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n2=q1.poll();
                if(n2.left!=null&& !visited.contains(n2.left))
                {
                    visited.add(n2.left);
                    q1.offer(n2.left);

                }
                  if(n2.right!=null&& !visited.contains(n2.right))
                {
                    visited.add(n2.right);
                    q1.offer(n2.right);

                }
                TreeNode parent=map.get(n2);
                if(parent!=null && visited.contains(parent)!=true)
                {
                    visited.add(parent);
                    q1.offer(parent);

                }
            }
            min++;

        }

        return min-1;
    }
}