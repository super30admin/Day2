// Time Complexity : O(1)
//Space Complexity : O(1000001) which is O(constant) So O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
Node [] storage;
    
    class Node{
        int key;
        int value;
        Node next;
        Node(int k,int v){
            this.key=k;
            this.value=v;
        }
    }
    public MyHashMap() {
         storage= new Node[1000001];
    }
    Node find(Node node, int k){
        Node prev=null;
        Node curr=node;
        while(curr!=null && curr.key!=k){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index=key % 1000001;
        if(storage[index]==null){
            storage[index]= new Node(-1,-1);
        }
        Node prev=find(storage[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else
        {
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int index=key % 1000001;
        if(storage[index]==null){
            return -1;
        }
         Node prev=find(storage[index],key);
        if(prev.next==null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index=key % 1000001;
        if(storage[index]==null){
            return;
        }
         Node prev=find(storage[index],key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
    }

public static void main(String args[]) {

 MyHashMap obj = new MyHashMap();
 obj.put(1,1);
 obj.put(2,2);
 obj.put(3,3);
int param_2 = obj.get(1);
 obj.remove(2);
 System.out.print(param_2);
 }
}