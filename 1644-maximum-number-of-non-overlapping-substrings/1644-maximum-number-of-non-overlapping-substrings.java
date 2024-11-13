class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();
        int[] start=new int[26];
        int[] end=new int[26];
        Arrays.fill(start,-1);
        Arrays.fill(end,-1);
        
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(start[idx]==-1) start[idx]=i;
            end[idx]=i;
        }

        List<int[]> intervals=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(start[i]!=-1){
                int l=start[i];
                int r=end[i];
                for(int j=l;j<=r;j++){
                    l=Math.min(l,start[s.charAt(j)-'a']);
                    r=Math.max(r,end[s.charAt(j)-'a']);
                }
                if(l==start[i]){
                    intervals.add(new int[]{l,r});
                }
            }
        }
        Collections.sort(intervals,(a,b)->a[1]-b[1]);

        List<String> res=new ArrayList<>();
        int prevend=-1;
        for(int[] in:intervals){
            if(in[0]>prevend){
                res.add(s.substring(in[0],in[1]+1));
                prevend=in[1];
            }
        }
        return res;
    }
}