class Solution {

    public void generate_permutation(int[] nums,List<Integer> curr,List<List<Integer>> res)
    {
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i])){
                continue;
            }
        
        curr.add(nums[i]);
     
            
            // 2. Explore
        generate_permutation(nums, curr, res);
            
            // 3. Un-choose (Backtrack)
        curr.remove(curr.size() - 1);
        // generate_permutation(nums,curr,res);
       

        }
        
    

    }
    public List<List<Integer>> permute(int[] nums) {
        //backtracking tree 
        List<List<Integer>> res=new ArrayList<>();
        //returns the result
        generate_permutation(nums,new ArrayList<>(),res);


return res;
        
    }
}