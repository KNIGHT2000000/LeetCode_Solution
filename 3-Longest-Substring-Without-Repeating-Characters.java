class Solution {
    public int lengthOfLongestSubstring(String s) {
    // we are given a string and we need to return length of longest 
    // substring without duplicate characters
    // we also need to maintain the frequency of each character
    /* and start window with size 1 and then keep on expanding the window till we dont have similar elemnt
     */
     // we used to have a hashset for this 
     Set<Character> set = new HashSet<>();
    int left = 0;
  int count=0;
  for(int right=0; right<s.length(); right++){
    // here we will go 
    char ch=s.charAt(right);
    while(set.contains(ch)){
         set.remove(s.charAt(left));
        left++;

    }
       set.add(ch);
      count=Math.max(count,right-left+1);
  }
    return count;
    }
}