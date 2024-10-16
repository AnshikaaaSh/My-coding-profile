class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int[] color=new int[v];
        for(int i=0;i<v;i++) color[i]=-1;
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(check(i,v,graph,color)==false) return false;
            }
        }
        return true;
    }

    public boolean check(int start, int v, int[][] graph, int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]) return false;
            }
        }
        return true;
    }
}