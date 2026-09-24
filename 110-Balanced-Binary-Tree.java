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
//     public int Max_height(TreeNode root,int h)
//     {   TreeNode t1=root;
       
//         if(t1!=null){
//              h1++;
      
//         Max_height(t1.left);
         
//         }
//         TreeNode t2=root;
//         if(t2!=null){
//              h2++;
//             Max_height(t2.right);
           
//         }

//         return Math.abs(h2-h1);
        

//                 //here we will get height left and height right

        

//     }
//     public boolean isBalanced(TreeNode root) {
//         if(root==null){
//             return true;
//         }
//        int height=Max_height(root);
//        if(height<=1){
//         return true;
//        }
//         return false;
        
//     }
// }

class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the helper function returns -1, it means the tree is unbalanced.
        // Otherwise, it returns the valid height of the tree.
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // The height of an empty tree is 0
        }

        // Check the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Propagate the failure up if the left subtree was unbalanced
        }

        // Check the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Propagate the failure up if the right subtree was unbalanced
        }

        // If the current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Otherwise, return the actual height of this subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}