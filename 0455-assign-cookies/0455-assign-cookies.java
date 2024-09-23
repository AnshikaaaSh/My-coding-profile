class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length, m=s.length,c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0,j=0;i<n;){
            if(j>=m) break;
            if(g[i]>s[j]){
                
                j++;
            }
            else{
                j++;i++;
                c++;
            }
        }
        return c;
    }
}