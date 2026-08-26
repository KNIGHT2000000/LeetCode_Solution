class Solution {
    public boolean check_bucket(int[] matchsticks, int index, int[] sides, int target) {
       if (index < 0) { 
            return true; 
        } 

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target)
                continue;

            sides[i] += matchsticks[index];
            if (check_bucket(matchsticks, index-1, sides, target)) {
                return true;
            }

            sides[i] = sides[i] - matchsticks[index];
            if (sides[i] == 0) {
                break;
            }

        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {

        //size 4 array for alll the bucket 

        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum = sum + matchsticks[i];

        }

        if (sum == 0 || sum % 4 != 0)
            return false;
        int target = sum / 4;

        Arrays.sort(matchsticks);
        int[] sides = new int[4];

        // 
        return check_bucket(matchsticks, matchsticks.length - 1,sides, target);
    }
}