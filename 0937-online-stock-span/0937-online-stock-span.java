class StockSpanner {
    Stack<Integer> s;
    List<Integer> l;
    public StockSpanner() {
        s=new Stack<>();
        l=new ArrayList<>();        
    }
    
    public int next(int price) {
        l.add(price);
        while(s.size()>0 && l.get(s.peek())<=price){
            s.pop();
        }
        int pgi;
        if(s.size()>0) pgi=s.peek();
        else pgi=-1;
        s.push(l.size()-1);
        return (l.size()-1)-pgi;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */