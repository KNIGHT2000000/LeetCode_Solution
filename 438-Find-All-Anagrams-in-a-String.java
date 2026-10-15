// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         // p all possible anangrams we have to chck with a 
//         // we can start a window and 

//         Map<Character, Integer> map1 = new HashMap<>();
//         Map<Character, Integer> map2 = new HashMap<>();
//         for (char ch : p.toCharArray()) {
//             map1.put(ch, map1.getOrDefault(ch, 0) + 1);
//         }
//         int left = 0;
//         int fix_length = p.length();
//         List<Integer> res = new ArrayList<>();
//         for (int right = 0; right < s.length(); right++) {
//             char ch2 = s.charAt(right);
//             map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);

//             if (right - left + 1 > fix_length) {
//                 char outgoing = s.charAt(left);

//                 map2.put(outgoing, map2.get(outgoing) - 1);

//                 if (map2.get(outgoing) == 0) {
//                     map2.remove(outgoing);
//                 }

//                 left++;
//             }
//             if (right - left + 1 == fix_length) {
//                 // fix length
//                 if (map1.equals(map2)) {

//                     res.add(left);
//                 }
//             }

//         }
//         return res;
//     }
// }

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m == 0 || m > n) {
            return res;
        }

        // Positive = extra required characters
        // Negative = extra characters in the window
        int[] diff = new int[26];

        for (char c : p.toCharArray()) {
            diff[c - 'a']++;
        }

        int nonZero = 0;

        for (int value : diff) {
            if (value != 0) {
                nonZero++;
            }
        }

        for (int right = 0; right < n; right++) {

            // Add incoming character
            int in = s.charAt(right) - 'a';

            if (diff[in] == 0) nonZero++;
            diff[in]--;
            if (diff[in] == 0) nonZero--;

            // Remove outgoing character if window is too large
            if (right >= m) {
                int out = s.charAt(right - m) - 'a';

                if (diff[out] == 0) nonZero++;
                diff[out]++;
                if (diff[out] == 0) nonZero--;
            }

            // Full window and all frequencies match
            if (right >= m - 1 && nonZero == 0) {
                res.add(right - m + 1);
            }
        }

        return res;
    }
}
