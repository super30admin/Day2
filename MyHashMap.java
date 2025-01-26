class MyHashMap {
    private Node[] nodeStore;
    private int buckets;
    public MyHashMap() {
        this.nodeStore=new Node[10000];
    }
    private int hashIdx(int key){
        return key%10000;
    }
    public Node search(Node head,int key){
        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null && currNode.key!=key){
            prevNode=currNode;
            currNode=currNode.next;
        }
        return prevNode;
    }
    public void put(int key, int value) {
        int idx=hashIdx(key);
        if(nodeStore[idx]==null) {
            nodeStore[idx]=new Node(-1,-1);
        }
        Node prevNode=search(nodeStore[idx],key);
        if(prevNode.next!=null){
            prevNode.next.val=value;
        }else{
            prevNode.next=new Node(key,value);
        }
    }

    public int get(int key) {
        int idx=hashIdx(key);
        if(nodeStore[idx]==null) return -1;
        Node prevNode=search(nodeStore[idx],key);
        if(prevNode.next==null){
            return -1;
        }else{
            return prevNode.next.val;
        }
    }

    public void remove(int key) {
        int idx=hashIdx(key);
        if(nodeStore[idx]==null) return;
        Node prevNode=search(nodeStore[idx],key);
        if(prevNode.next==null){
            return;
        }
        Node temp=prevNode.next;
        prevNode.next=temp.next;
        temp.next=null;
    }



    public class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}


