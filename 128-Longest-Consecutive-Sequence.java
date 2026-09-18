class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
    // first intution here is to sort this stuff
    Arrays.sort(nums);
    //now we have to count the longest sommon subsequence consequtive
    // wehave to do count as well as check consequitive and store the result
    int count=1;
    int max_count=1;
    
    int j=1;
    while(j<nums.length){
        if(nums[j]!=nums[j-1]){
        if(nums[j]-nums[j-1]==1)//condition for checking the consecutive numbers
        {
            count++;
            // j++;
        }
        else{
        max_count=Math.max(max_count,count);
        count=1;
        // j++;
        }



    }
    j++;
    }
    return Math.max(max_count,count);

        
    }
}