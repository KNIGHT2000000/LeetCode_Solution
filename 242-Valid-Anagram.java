class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        

        //simple hashmap technique to compare the frequencies
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        // now we count
        for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        map1.put(c,map1.getOrDefault(c,0)+1);//count freq
        }
        for(int i=0;i<t.length();i++){
        char y=t.charAt(i);
        map2.put(y,map2.getOrDefault(y,0)+1);//count freq
        }
        if(map1.equals(map2)){
            return true;
        }
        return false;
        

        
        
        
            }
}