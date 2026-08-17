
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int n = nums.length;

        // 1. Find First Position (Left Boundary)
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                high = mid - 1; // Keep searching the left half
            } else if (nums[mid] < target) {
                low = mid + 1;  // Target is to the right
            } else {
                high = mid - 1; // Target is to the left
            }
        }

        // 2. RESET pointers to search again
        low = 0;
        high = n - 1;

        // 3. Find Last Position (Right Boundary)
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                low = mid + 1;  // Keep searching the right half
            } else if (nums[mid] < target) {
                low = mid + 1;  // Target is to the right
            } else {
                high = mid - 1; // Target is to the left
            }
        }

        return res;
    }
}
