class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // Start with the first element
        int maxSum = nums[0];      // Maximum sum found so far
        
        // Traverse the array from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide to start a new subarray or continue the existing one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum; // Return the largest sum
    }
}
