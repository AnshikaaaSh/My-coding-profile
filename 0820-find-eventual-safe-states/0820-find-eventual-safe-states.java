class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> res=new ArrayList<>();
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(safe(graph,i,state)) res.add(i);
        }
        return res;
    }

    private boolean safe(int[][] graph, int i, int[] state){
        if(state[i]!=0) return state[i]==2;
        state[i]=1;
        for(int j:graph[i]){
            if(state[j]==1 || !safe(graph,j,state)) return false;
        }
        state[i]=2;
        return true;
    }
}