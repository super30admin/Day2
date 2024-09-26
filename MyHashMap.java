public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    Node[] nodes;
    int buckets;
    public MyHashMap() {
        nodes= new Node[10000];
        buckets=10000;
    }

    public void put(int key, int value) {
        int index=getIndex(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1);
        }
        Node prev=findPrev(nodes[index],key);
        if(prev.next==null){
            prev.next= new Node(key,value);
        }else{
            prev.next.value=value;
        }
    }

    public int get(int key) {
        int index=getIndex(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev=findPrev(nodes[index],key);
        if(prev.next==null){
            return -1;
        }else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index=getIndex(key);
        if(nodes[index]==null){
            return;
        }
        Node prev=findPrev(nodes[index],key);
        if(prev.next==null){
            return;
        }else{
            prev.next=prev.next.next;
        }
    }

    private int getIndex(int key){
        return Integer.hashCode(key) % buckets;
    }

    private Node findPrev(Node head, int key){
        Node prev=head;
        Node curr=head.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
}
