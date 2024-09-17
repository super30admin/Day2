//Time complexity: O(N)
//Space Complexity:O(N)

class MyHashMap {
    
    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    int buckets;
    Node container[];
    public MyHashMap() {
        buckets=10000;
        container=new Node[buckets];
        
    }
    private int getIndex(int key){
        return Integer.hashCode(key)%buckets;
    }
    private Node find(Node node,int key){
        Node prev=node;
        Node curr=node.next;
        while(curr!=null && prev.next.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index=getIndex(key);
        if(container[index]==null){
            container[index]=new Node(-1,-1);
            
        }
        Node prev=find(container[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        prev.next.value=value;
    }
    
    public int get(int key) {
         int index=getIndex(key);
        if(container[index]==null){
            return -1;
        }
        Node prev=find(container[index],key);
        if(prev.next==null){
            return -1;
        }
       return prev.next.value;
    }
    
    public void remove(int key) {
        int index=getIndex(key);
        if(container[index]==null){
            return ;
        }
        Node prev=find(container[index],key);
        if(prev.next==null){
            return;
        }
        else{
            prev.next=prev.next.next;
        }
    }
    public static void main(String args[]){
        MyHashMap obj=new MyHashMap();
        obj.put(10, 10000);
        System.out.println(obj.get(12));
        obj.remove(12);
        System.out.println(obj.get(10));

    }
}
