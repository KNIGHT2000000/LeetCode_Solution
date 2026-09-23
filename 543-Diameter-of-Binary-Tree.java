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
//     public int heightl(TreeNode root,int hl){
       
//         if(root!=null){
//             hl++;
//             heightl(root.left,hl);
//         }
//         return hl;
//     }
//     public int heightr(TreeNode root,int hr){
//          if(root!=null){
//             hr++;
//             heightr(root.right,hr);
//         }
// return hr;
//     }

  
//     public int diameterOfBinaryTree(TreeNode root) {
       
//         // we need to count edges between the leftmost lowest path to rightmost lowest leaf node
//         //so to begin with this by counting the hight of tree till lowest node in left and then in right
//         int heightleft=Math.max(heightl(root.left,0),heightr(root.left,0));
//         int heightright=Math.max(heightl(root.right,0),heightr(root.right,0));
//         return heightleft+heightright+1;
//             }
// }

class Solution {
    // 1. Simplify the height function to only need the node itself
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Get the height of both sides and add 1 for the current node
        int hl = height(root.left);
        int hr = height(root.right);
        
        return 1 + Math.max(hl, hr); 
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 2. Fix the method calls (remove comma, use single argument)
        int heightleft = height(root.left);
        int heightright = height(root.right);
        
        // The diameter if the path goes through the current root
        int rootDiameter = heightleft + heightright;

        // 3. Recursively check if the left or right subtrees have a larger diameter inside them
        int leftSubtreeDiameter = diameterOfBinaryTree(root.left);
        int rightSubtreeDiameter = diameterOfBinaryTree(root.right);

        // Return the maximum of all three possibilities
        return Math.max(rootDiameter, Math.max(leftSubtreeDiameter, rightSubtreeDiameter));
    }
}