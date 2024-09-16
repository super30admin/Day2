//Time complexity=O(1)
//Space Complexity=O(n)
public class HashMap {

    public class Node{
        int key,val;
        Node next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    private Node []nodes;
    public HashMap() {
        nodes=new Node[10000];
    }

    private int idx(int key){
        return key%10000;
    }

    private Node find(Node head, int key){
        Node prev=null;
        Node current=head;

        while(current!=null && current.key!=key){
            prev=current;
            current=current.next;
        }
        return prev;
    }
    public void put(int key, int val) {
        int idx=idx(key);
        if(nodes[idx]==null){
            nodes[idx]=new Node(-1,-1);
        }
        Node prev=find(nodes[idx],key);
        if(prev.next==null){
            prev.next=new Node(key,val);
        }else{
            prev.next.val=val;
        }
    }

    public int get(int key) {
        int idx=idx(key);
        if(nodes[idx]==null){
            return -1;
        }
        Node prev=find(nodes[idx],key);
        if(prev.next==null){
            return -1;
        }else{
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int idx=idx(key);
        if(nodes[idx]==null){
            return;
        }
        Node prev=find(nodes[idx],key);
        if(prev.next==null){
            return;
        }else{
            prev.next=prev.next.next;
        }
    }
}
