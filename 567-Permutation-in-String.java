class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        // logic is clear store 
        int[] count =new int[26];
        int[] s2count = new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        //sldiding window
        for(int i=s1.length();i<s2.length();i++){
            if(Arrays.equals(count,s2count)){
                return true;
            }

            s2count[s2.charAt(i) - 'a']++;//add the new one at the index of the next 
            s2count[s2.charAt(i-s1.length())-'a']--;
        }
        return Arrays.equals(count, s2count);
    }
    
}
