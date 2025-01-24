// Time Complexity :amortised O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    Node [] storage;
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public MyHashMap() {
        storage=new Node[10000];
    }
    public int hash1(int key){
        return key%10000;
    }
    public Node find(Node head,int key){
        Node prev=null;
        Node current=head;
        while(current != null && current.key != key){
            prev=current;
            current=prev.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index=hash1(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        }
        Node prev=find(storage[index],key);
        if(prev.next != null){
            prev.next.value=value;
        }else{
 prev.next=new Node(key,value);
        }
       
    }
    
    public int get(int key) {
        int index=hash1(key);
        if(storage[index] != null){
        Node prev=find(storage[index],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
        }else{
       return -1;
        }
       
    }
    
    public void remove(int key) {
        int index=hash1(key);
        if(storage[index] != null){
         Node prev=find(storage[index],key);
         if(prev.next != null){
          Node temp=prev.next;
        prev.next=prev.next.next;
        
         }else{
            return;
         }

        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
