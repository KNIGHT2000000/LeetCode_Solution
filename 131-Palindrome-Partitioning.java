class Solution {
    public static  boolean IsPalindrome(String s, int start, int end){
          // Loop while start is less than end
        while (start < end) {
            // If characters at start and end are not equal, it's not a palindrome
            if (s.charAt(start) != s.charAt(end)) return false;
            // Move start forward and end backward
            start++;
            end--;
        }
        // If all characters matched, it's a palindrome
        return true;






    }


    public static void genrate_partition(int index,String s,List<List<String>> res,List<String> curr){
        if(index==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
// from here we need to try all possible substring 
for(int i=index;i<s.length();i++){
    if(IsPalindrome(s,index,i)){
        curr.add(s.substring(index,i+1));
        genrate_partition(i+1,s,res,curr);
        curr.remove(curr.size()-1);
    }
   
}



    }

    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        genrate_partition(0,s,res,curr);
        return res;






        
    }
}