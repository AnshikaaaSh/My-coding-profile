class LRUCache {
    int cap;
    HashMap<Integer, Node> m=new HashMap();
    Node head=new Node(0,0), tail=new Node(0,0);
    
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;    
    }
    
    public int get(int key) {
        if(m.containsKey(key)){
            Node node=m.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            remove(m.get(key));
        }
        if(m.size()==cap){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    private void remove(Node node){
        m.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insert(Node node){
        m.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    class Node{
        Node next,prev;
        int key, value;
        Node(int _key, int _value){
            key=_key;
            value=_value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */