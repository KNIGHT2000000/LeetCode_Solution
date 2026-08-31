//bad approach--> defaeats the purpose of hashmap and o(n2)

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         //return 2 indices if element if the duplicate exists and abs()
//            Map<Integer,Integer> mp =new HashMap<>();
//      // the approach here is to loop throught the hashmap and 
//      for(int i=0;i<nums.length;i++){
//         mp.put(i,nums[i]);
//      }  


// for(int i=0;i<nums.length;i++){


//      //now wehave to loop over ecah entry
//      for(Map.Entry<Integer,Integer> entry :mp.entrySet() ){
//         if(i==entry.getKey()){
//             continue;
//         }
//         if(nums[i]==entry.getValue() && Math.abs(i-entry.getKey())<=k){
//             return true;

//         }
//         else{
//             continue;
//         }



        
//      }    }

//      return false;
//     }
// }
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