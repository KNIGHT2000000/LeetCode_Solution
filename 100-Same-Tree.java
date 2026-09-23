// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> Compute(TreeNode n,List<List<Integer>> res)
//     {
//         Queue<TreeNode> q =new LinkedList<TreeNode>();
//         if(n==null){
//             return res;
//         }
//         q.offer(n);
//         while(!q.isEmpty()){
//             int size=q.size();
//             //size of current of the queue
//             List<Integer> level=new ArrayList<>();
//             for(int i=0;i<size;i++){
//                 TreeNode node=q.poll();
//                 level.add(node.val);

//                 if(node.left !=null){
//                     q.offer(node.left);
//                 }
//                 if(node.right !=null){
//                     q.offer(node.right);

//                 }
//             }
//             // Collections.sort(level);
//             res.add(level);
//         }
//         // we recieve tree node here and we can compare by applybs and then sorliting it at each level 
//         return res;
//     }
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         //for same tree the level order starversal should be perfectly merged 
//         //actually we can focus on sorting the stuff
//         //at each level w ehave to use sort
//         List<List<Integer>> list1=new ArrayList<>();
//         List<List<Integer>> list2=new ArrayList<>();
//         list1=Compute(p,list1);
//         list2=Compute(q,list2);
//         if(list1.equals(list2)){
//             return true;
//         }
//         return false;


        
//     }
// }

class Solution {
    // ప్రతి లెవెల్‌లోని నోడ్స్ (null తో సహా) స్ట్రక్చర్‌ను కంప్యూట్ చేయడానికి
    public List<List<Integer>> Compute(TreeNode n, List<List<Integer>> res) {
        if (n == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(n); // మొదటి తప్పు ఫిక్స్: క్యూలో రూట్ నోడ్ యాడ్ చేయడం

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            boolean hasMoreNodes = false; 
            List<TreeNode> nextLevelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node == null) {
                    level.add(null); 
                } else {
                    level.add(node.val);
            
                    nextLevelNodes.add(node.left);
                    nextLevelNodes.add(node.right);

                    if (node.left != null || node.right != null) {
                        hasMoreNodes = true; 
                    }
                }
            }

            res.add(level);

            if (hasMoreNodes) {
                for (TreeNode nextNode : nextLevelNodes) {
                    q.offer(nextNode);
                }
            }
        }
        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        
        list1 = Compute(p, list1);
        list2 = Compute(q, list2);
        
        return list1.equals(list2);
    }
}
