
public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        Arrays.fill(first, s.length());
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }
        int[] l = new int[s.length()];
        Arrays.fill(l, -1);

        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i) - 'a'] == -1) continue;
            if (first[s.charAt(i) - 'a'] != i) continue;

            int c = i;
            int max = last[s.charAt(c) - 'a'];
            while (true) {
                if (c == max) {
                    l[i] = max;
                    break;
                }
                c++;
                if (first[s.charAt(c) - 'a'] < i) break;
                max = Math.max(max, last[s.charAt(c) - 'a']);
            }
        }

        // find the minimum last index every time from the list.
        List<String> ans = new ArrayList<>();
        int start = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = start; i <= Math.min(min, s.length() - 1); i++) {
                if (l[i] != -1  && l[i] <= min) {
                    min = l[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            ans.add(s.substring(minIndex, l[minIndex] + 1));
            start = min + 1;
        }
        return ans;
    }
}
