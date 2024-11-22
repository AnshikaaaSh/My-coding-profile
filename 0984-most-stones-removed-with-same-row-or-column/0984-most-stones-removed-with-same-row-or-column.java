class Solution {
    int n, parent[];
    public int removeStones(int[][] stones) {
        n=stones.length;
        parent=new int[20001];
        for(int i=0;i<20001;i++){
            parent[i]=i;
        }
        for(int[] s:stones){
            int u=s[0];
            int v=s[1]+10001;
            union(u,v);
        }
        Set<Integer> components=new HashSet<>();
        for(int[] s:stones){
            components.add(find(s[0]));
        } 
        return n-components.size();
    }
    public void union(int u,int v){
        int paru=find(u);
        int parv=find(v);
        parent[paru]=parv;
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
}