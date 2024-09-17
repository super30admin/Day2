// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashMap {
    
    class Node{
        int key,value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node[] nodes;
    int buckets;
    
    private int getBucket(int key){
        return key%buckets;
    }
    
    private Node find(Node head,int key){
       
        Node prev=head;
        Node curr=head.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public MyHashMap() {
        buckets=1000;
        nodes= new Node[buckets];
        
    }
    
    public void put(int key, int value) {
        int index=getBucket(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1);
        }
        Node prev = find(nodes[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int index=getBucket(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index]==null){
            return;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

MY APPROACH:

Here we are using Array of NODE as we have key with value so first creating NODE class in which we have value and key and NODE next as we are using LinkedList.
1.Now method gutbucket will always give us keys Index in Array. 
2. If index is empty just create new NODE and that two first dummy node to handle edge case where ( if we will be asked to remove first link means head only how we will attach remaining list to NodeArray[index]) so dummy node which will have (-1,-1) key and value to avoid collision with ranged keys.
3. Now when we PUT we need to UPDATE sometime when key already exists to REMOVE we need key TO GET we need key. SO everywhere first we have to find if NODE is exist with that key or not so WE will writing Find() method.
4. Find method will be find(NODE,key) giving node is important as we need to set head to traverse list if key is available or not. So find(nodesArray[index],key). Now we will set prev to head and current to head.next and traverse till matching key is found or current is null means list ends in both case we will return previous node
5. Returning previous because while removing we need previous node to attach to next node. 
6. Now operations while PUT if exist we will get prev and we will update prev.next.value
7. While remove we will do prev.next=prev.next.next;
8. One thing to node when we will perform PUT after assigning prev=find(nodes[index],key) if list is not having node of key value also it will return prev so always we have to check prev.next==null if true means not found so create new node with key value prev.next = new Node(key,val); 