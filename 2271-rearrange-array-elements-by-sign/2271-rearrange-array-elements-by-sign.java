class Solution {
    public int[] rearrangeArray(int[] nums) {
       int arr[] = new int[nums.length]; // Create a new array for rearrangement
       int pos = 0; // Pointer for positive numbers
       int neg = 1; // Pointer for negative numbers
       int i = 0; // Index for iteration
       
       // Traverse through the input array
       while (i < nums.length) {
           if (nums[i] >= 0) { // If positive, place at `pos` index
               arr[pos] = nums[i];
               pos += 2; // Move to the next position for positive numbers
           } else { // If negative, place at `neg` index
               arr[neg] = nums[i];
               neg += 2; // Move to the next position for negative numbers
           }
           i++; // Move to the next element in the input array
       }
       return arr; // Return the rearranged array
    }
}