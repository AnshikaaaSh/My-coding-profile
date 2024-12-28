//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index to store merged elements
        int count = 0;   // Count of inversions

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid + 1 - i); // Count inversions
            }
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

    public static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left subarray
            count += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in right subarray
            count += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count inversions during merge
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    public static int inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

}
