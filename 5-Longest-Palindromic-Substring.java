class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        // String s
        // genrate all substring and then check palindrome on it
        //approach first check the two pointer 
   if(s.length()==0 || s==null){
    return s;
   }
   // String reversed = new StringBuilder(original).reverse().toString();
   String rev=new StringBuilder(s).reverse().toString();
   // this will reverse the string completely
   if(rev==s){
    return s;
   }
   for(int i=0;i<s.length();i++){
   int len1=return_max_len(s,i,i);//for odd length
   int len2=return_max_len(s,i,i+1);//for even length
   int len =Math.max(len1,len2);
   if(len>end-start){
    start=i-(len-1)/2;
    end=i+len/2;
   }
    
    


        
    }
    return s.substring(start, end + 1);}
    public int return_max_len(String s,int left,int right){
        //
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


}