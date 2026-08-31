class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0 || strs==null){
               return new ArrayList<>();
        }
        //group anagrams
        //brute force 
        Map<String,List<String>> mp =new HashMap<>();
      
        for(String str : strs){
            char[] chr=str.toCharArray();
            Arrays.sort(chr);
            String s=new String(chr);
            // if(mp.contains(s) {
            //     res.add(str);
            // }
            // else{
            //     mp.put(s,new Arraylist<>(str));
            // }
            if(!mp.containsKey(s)){
                mp.put(s,new ArrayList<>());
            }
            
                mp.get(s).add(str);
                
          

        }
       return new ArrayList<>(mp.values());
    }
}