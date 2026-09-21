class Solution {
    public int subarraySum(int[] nums, int k) {
//         // we have to use 2 pointer approach and find this 
//         // we need to chek when nums[i]==k-->ct++
//         int i=0;
//         int j=1;
//         int count=0;
//         //here we have to work on subarray not on subsequence
//         //we need slididng window
//         //we need to add and reduce the last one 
        

//         while(i<nums.length && j<nums.length){
//             if(nums[i]==k){
//                 count++;
//             }
//             if(nums[i]+nums[j]==k){
//                 count++;
//                 j++;
//             }
//             i++;
            
//         }
// return count;

//prefix and hashmap
Map<Integer,Integer> mp=new HashMap<>();
//hashmap created for this approach for each prefix sum and frequency
mp.put(0, 1);
int currentSum = 0;
int totalSubarrays = 0;
for(int i=0;i<nums.length;i++){
    currentSum+=nums[i];

int needed = currentSum - k;
if(mp.containsKey(needed)){
    totalSubarrays+=mp.get(needed);


}
mp.put(currentSum,mp.getOrDefault(currentSum,0)+1);


}
   return totalSubarrays;     
    }
}