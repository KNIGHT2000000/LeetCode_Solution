class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        // placed it in
        HashSet<String> visited = new HashSet<>();
        // we need to model this problem either as tree or graph problem 
        // modeling it into grid also works
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals("0000") || deadends[i].equals(target)){
                return -1;
            } 
            else
            {
                visited.add(deadends[i]);
                //added all of the depends in the visited already to prevent visisting them at all from
                //starting  

            }
        }

        // used to place the String in visisted
        q.offer("0000");
        visited.add("0000");
        int distance = 0;
        while (!q.isEmpty()) {
            // poll 
            int size=q.size();
            for (int j = 0; j < size; j++) {
                String node = q.poll();
                
                if (node.equals(target)) {
                    return distance;
            }
           
          
            //now is the node doesnt contain target and also is not part of visited add all the eight babies in it
            // //genrate all the neighbours if not in visisted add them to q 
            // for(char ch : node.toCharArray){
            //    int value = Integer.parseInt(String.valueOf(ch));
            //    if(value!=9){
            //     q.offer()

            //    }

            // }
            // Convert the current node to a char array so we can easily modify individual characters
            char[] chars = node.toCharArray();

            // Iterate through each of the 4 dials
            for (int i = 0; i < 4; i++) {
                char originalChar = chars[i]; // Store the original character so we can backtrack

                // 1. Calculate the +1 move (Up)
                // If it's '9', wrap to '0'. Otherwise, just add 1 to the char.
                chars[i] = (originalChar == '9') ? '0' : (char) (originalChar + 1);
                String upNode = new String(chars);

                if (!visited.contains(upNode)) {
                    visited.add(upNode);
                    q.offer(upNode);
                }

                // 2. Calculate the -1 move (Down)
                // If it's '0', wrap to '9'. Otherwise, subtract 1 from the char.
                chars[i] = (originalChar == '0') ? '9' : (char) (originalChar - 1);
                String downNode = new String(chars);

                if (!visited.contains(downNode)) {
                    visited.add(downNode);
                    q.offer(downNode);
                }

                // 3. Restore the original character before checking the next dial
                chars[i] = originalChar;
            }
            }
            distance++;

        }
        return -1;
    }
}
