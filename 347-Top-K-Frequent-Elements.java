class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     int[] res =new int[k];

     
        // here we can store each of the values with freq and index
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            // mp.containsKey(nums[i]){
            //     //if the key exists alread
            //     mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            // }
            // else{
            //     mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            // }
        }

// for(Map.Entry<Integer, Integer> entry : mp.entrySet())
// {
//     if(mp.getValue()==k){
//         ls.add(mp.getKey());
        



//     }
   
// The index of this array represents the frequency of the elements
List<Integer>[] buckets = new List[nums.length + 1];
// here is the game plan so 
for(int key : mp.keySet()){
    //loop over all the key set
    int freq=mp.get(key);
    //freq stored
    if(buckets[freq]==null){
        buckets[freq]=new ArrayList<>();
    }
    buckets[freq].add(key);//added the key to it

}
int count=0;
//soprting and getting the right top k
for(int i=buckets.length-1;i>=0 && count<k;i--){
    if(buckets[i]!=null){
        for(int num : buckets[i]){
        res[count]=num;
        count++;
        if(count==k){
            break;
        }
    }}


}
   
      return res;  
        
    }
}