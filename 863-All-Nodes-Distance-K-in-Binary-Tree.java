/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public Map<TreeNode,TreeNode> compute_Parents(TreeNode root,Map<TreeNode,TreeNode> map){
        //compute the very basics of this stuff
        if(root==null){
            return null;
        }
           Queue<TreeNode> q = new LinkedList<>();
           // there is tradeoff when to use the LinkedList<>() and when ArrayDeque
           q.offer(root);
           while(!q.isEmpty()){
            TreeNode n1=q.poll();
            
            if(n1.left!=null){
                map.put(n1.left,n1);
                q.offer(n1.left);
                // parent mil gaya
            }
            if(n1.right!=null){
                map.put(n1.right,n1);
                q.offer(n1.right);
            }
           }


return map;

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> distance_node =new ArrayList<>();
           Queue<TreeNode> q1 = new LinkedList<>();
    // how to we populate parents of parents
        int count=0;
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode,TreeNode> map=new HashMap<>();
        // this will give all the mapping for the particular 
    //apply dfs and for each node we have to add the parents
    map= compute_Parents(root,map);
    //now map has parents for each of them
    //now we will apply bfs on the very target node
    if(target==null){
        return null;

    }
    q1.offer(target);
    visited.add(target);
    while(!q1.isEmpty()){
       
        if(count==k){
            while(!q1.isEmpty()){
                TreeNode node1=q1.poll();
            distance_node.add(node1.val);
            }

            // we have to check distance for each of the given node 
       return distance_node;
    
        }
         int size=q1.size();
        for (int i = 0; i < size; i++){
            
        TreeNode node=q1.poll();
        if(node.left!=null && visited.contains(node.left)!=true){
            visited.add(node.left);

        q1.offer(node.left);
        }
        if(node.right!=null && visited.contains(node.right)!=true){
            visited.add(node.right);
            q1.offer(node.right);
        }
        
        TreeNode p = map.get(node);
        if(p!=null && !visited.contains(map.get(node)) )
        { visited.add(p);

            q1.offer(p);
        }}
        count++;

    }
    return distance_node;
}}