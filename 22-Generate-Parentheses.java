class Solution {
    public static void genrate_helper(int open ,int close,int n,List<String> res,String s){
        if(s.length()==2*n){
            res.add(s);
            return;

        }
        if(open <n){
            genrate_helper(open+1,close,n,res,s+"(");
        }
        if(close<open){
             genrate_helper(open,close+1,n,res,s+")");
        }

    }




    
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
       genrate_helper(0, 0, n, res, "");
        // we have to 


        return res;
        
    }
}