class Solution {
    public int majorityElement(int[] nums) {
        int n=(int)nums.length/2;

        HashMap<Integer , Integer>mapp =new HashMap<>();
        for(int ele : nums)
        {
            mapp.put(ele,mapp.getOrDefault(ele,0)+1);
        }
       for (Map.Entry<Integer, Integer> entry : mapp.entrySet()) {
            // The majority element appears MORE THAN n times
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return -1;
        
    }
}