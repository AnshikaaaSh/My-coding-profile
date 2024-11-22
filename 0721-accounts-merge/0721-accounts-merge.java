class Solution {

    int[] parent;
    int[] rank;
    public int find(int x){
        if(x==parent[x]) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int u, int v){
        int pu=find(u);
        int pv=find(v);
        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
            rank[pu]++;
        }
        else{
            parent[pu]=pv;
            rank[pv]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Map<String,Integer> mailMap=new HashMap<>();
        for(int i=0;i<n;i++){
            int m=accounts.get(i).size();
            for(int j=1;j<m;j++){
                String mailadd=accounts.get(i).get(j);
                if(!mailMap.containsKey(mailadd)) mailMap.put(mailadd,i);
                else union(i,mailMap.get(mailadd));
            }
        }
        Map<Integer, Set<String>> distinctgm=new HashMap<>();
        for(int i=0;i<n;i++){
            parent[i]=find(i);
            int accsize=accounts.get(i).size();
            distinctgm.putIfAbsent(parent[i], new HashSet<>());
            distinctgm.get(parent[i]).addAll(accounts.get(i).subList(1,accsize));
        }
        List<List<String>> ans=new ArrayList<>();
        for(int g:distinctgm.keySet()){
            List<String> emailList=new ArrayList<>(distinctgm.get(g));
            Collections.sort(emailList);
            emailList.add(0,accounts.get(g).get(0));
            ans.add(emailList);
        }
        return ans;
    }
}