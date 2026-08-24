class Solution {
    public static void genrate_ph_combination(List<String> res, String curr, String digits, int index, int n,
            String[] mapping) {

        if ((curr.length() == digits.length()) && index == n) {
            res.add(curr);
            return;

        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // Append current char and move to the next index
            // genrate_ph_combination(res, curr + letters.charAt(i), digits, index + 1, n, mapping);
            curr += letters.charAt(i);
            genrate_ph_combination(res, curr, digits, index + 1, n, mapping);
            curr=curr.substring(0, curr.length() - 1);//curr = curr.substring(0, curr.length() - 1);

        }

        //

    }

    public List<String> letterCombinations(String digits) {
        String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();
        genrate_ph_combination(res, "", digits, 0, digits.length(), mapping);

        return res;
        // all the digits are given along with mapping 
        //we will have to get mapping 

    }
}