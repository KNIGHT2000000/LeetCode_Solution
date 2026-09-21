class Solution {
    public int firstMissingPositive(int[] nums) {

        // we need to scan array 3 time
        // first scane me we clean the array
        int res=nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length){
             nums[i]=nums.length+1;



            }


        }
        //second time for inmoemeory manipulation
        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i]);
            if(val<=nums.length){
            int index=val-1;
            if(nums[index] > 0){
            nums[index] = -nums[index];
        }}
        }

         // third iteration for 
         for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res=i+1;
                break;
            }
         }

        return res;
    }
}