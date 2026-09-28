class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        // WE ADD NEXT POINTER 
        Queue<Node> n = new LinkedList<>(); 
        n.offer(root); 
        
        while(!n.isEmpty()) {
            int s = n.size(); 
            Node[] level = new Node[s]; 
            
            for(int i=0; i<s; i++) {
                // here we will poll out each node
                Node node = n.poll(); 
                
                // Fixed: Assign to the 'level' array, not the 'Node' class
                level[i] = node; 
                
                if(node.left != null) {
                    n.offer(node.left); 
                } 
                if(node.right != null) {
                    n.offer(node.right); 
                } 
            } 
            
            // Fixed: Arrays use .length, not .size()
            int s1 = level.length; 
            
            for(int i=0; i<s1; i++) {
                if(i == s1 - 1) {
                    // Fixed: Renamed 'n' to 'currNode' to avoid conflict with the Queue
                    Node currNode = level[i];
                    currNode.next = null;
                } else {
                    Node currNode = level[i];
                    currNode.next = level[i + 1];
                }
            }
        }
        
        return root;
    }
}