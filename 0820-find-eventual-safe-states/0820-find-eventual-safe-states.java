class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }

        int[] outd=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                al.get(graph[i][j]).add(i);
                outd[i]++;
            }
        }

        int[] safe=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outd[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            safe[curr]=1;
            for(int a:al.get(curr)){
                outd[a]--;
                if(outd[a]==0) q.add(a);
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]==1) ans.add(i);
        }
        return ans;
    }
}