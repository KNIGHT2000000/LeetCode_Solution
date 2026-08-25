class Solution {
    public int missingMultiple(int[] nums, int k)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) 
        {
            set.add(nums[i]);
        }
        for(int i = k; i <= 10000; i += k) 
        {
            if(!set.contains(i)) 
                return i;
        }
        return -1;
    }
}