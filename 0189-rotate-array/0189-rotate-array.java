class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Corrected the variable name
        int[] temp = new int[n];
        // Copy the last k elements to the temp array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }
        // Shift the first n - k elements to the right by k positions
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        // Copy the temp array to the first k positions of the nums array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
