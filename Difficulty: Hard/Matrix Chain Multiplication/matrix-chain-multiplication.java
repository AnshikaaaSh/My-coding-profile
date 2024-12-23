//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int find(int i,int j,int[][] dp,int[] arr){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int curr = (arr[i-1]*arr[k]*arr[j])+find(i,k,dp,arr)+find(k+1,j,dp,arr);
            res = Math.min(res,curr);
        }
        return dp[i][j] = res;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>0;i--){
            for(int j=i+1;j<n;j++){
                int res = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int curr = (arr[i-1]*arr[k]*arr[j])+dp[i][k]+dp[k+1][j];
                    res = Math.min(res,curr);
                }
                dp[i][j] = res;
            }
        }
        return dp[1][n-1];
    }
}