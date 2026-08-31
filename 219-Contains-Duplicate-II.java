class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // we have to store value and index as key value pair remember phonbe book analogy 
        //dont /never store phone book mapped to name when you need to get phonenumber
        // with name 
        //defaets purpose of hashmap
        Map<Integer, Integer> mp = new HashMap<>();
        //now 
        for (int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])&& Math.abs(i-mp.get(nums[i]))<=k){
                return true;
            }

            else{
                mp.put(nums[i],i);
                
            }

        }
        return false;
    }
}