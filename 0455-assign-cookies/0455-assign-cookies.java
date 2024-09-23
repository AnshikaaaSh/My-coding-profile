class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // int c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        // for(int i=0,j=0;i<n;){
        //     if(j>=m) break;
        //     if(g[i]>s[j]){
                
        //         j++;
        //     }
        //     else{
        //         j++;i++;
        //         c++;
        //     }
        // }

        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;j++;
                
                continue;
            }
            else j++;
        }
        return i;
    }
}