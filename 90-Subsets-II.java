class Solution {
    public void Generate_subset(int index,int[] nums,List<Integer> curr,List<List<Integer>> res){
        if(index==nums.length){
            if(!res.contains(curr)){
            res.add(new ArrayList<>(curr));}
        
            return ;
        }
        curr.add(nums[index]);
        //choice of taking the element at that index
        Generate_subset(index+1,nums,curr,res);
        //here we get one subset
        //we have to check with res


        curr.remove(curr.size()-1);
        Generate_subset(index+1,nums,curr,res);


    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        //now we dont have the index we have to treat this as main
        int i=0;
        List<List<Integer>> res=new ArrayList<>();
        //this will contain alll the rerquired arraylist of arraylist 
        Generate_subset(i,nums,new ArrayList<>(),res);


        return res;

        

        
    }
}