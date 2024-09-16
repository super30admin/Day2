// Time Complexity : average case O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {
    int size;
    class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    Node [] storage = new Node[10000];
    public MyHashMap() {
        this.size=10000;
    }
    
    public int hash(int key){
        return key%size;
    }
    
    private Node find(Node node, int key){
        Node prev=null;
        Node cur=node;
        while(cur != null && cur.key!= key ){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx=hash(key);
        if(storage[idx]==null){
            storage[idx]=new Node(-1,-1);
        }
        Node prev=find(storage[idx], key);
        if(prev.next==null){
            prev.next=new Node(key, value);
        }else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int index=hash(key);
        if(storage[index]==null) return -1;
        Node prev=find(storage[index], key);
        if(prev.next==null) return -1;
        else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int index=hash(key);
        if(storage[index]==null) return;
        Node prev=find(storage[index], key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
