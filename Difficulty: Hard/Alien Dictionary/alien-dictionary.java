//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int k) {
        // Create adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph based on the given dictionary
        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean foundDifference = false;

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    foundDifference = true;
                    break;
                }
            }

            // If no difference was found and s1 is longer than s2, it's invalid
            if (!foundDifference && s1.length() > s2.length()) {
                return "";
            }
        }

        // Perform topological sort
        List<Integer> topoOrder = topoSort(k, adj);
        if (topoOrder.size() < k) return ""; // Cycle detected, invalid ordering

        // Convert the topological order into a string
        StringBuilder res = new StringBuilder();
        for (int it : topoOrder) {
            res.append((char) (it + 'a'));
        }
        return res.toString();
    }

    private static List<Integer> topoSort(int k, List<List<Integer>> adj) {
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) queue.add(it);
            }
        }

        // If topological sort doesn't include all nodes, it means there's a cycle
        if (ans.size() < k) {
            return new ArrayList<>();
        }
        return ans;
    }
}