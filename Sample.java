// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

class Node{

        int key;
        int value;
        Node next;
    
    public Node(int key,int value){

        this.key = key;
        this.value = value;

    }

}

    Node[] storage;
    int buckets;



    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
        
    }

    private int getPrimaryHash(int key){
        return key % buckets;
    }
    
    private Node getPrevNode(Node head, int key){

            Node prev = null;
            Node curr = head;
        while(curr!=null && curr.key!=key){

            prev = curr;
            curr = curr.next;
        }
        return prev;

    }
    public void put(int key, int value) {
        
        int primIndex = getPrimaryHash(key);
        if(storage[primIndex] == null){
            storage[primIndex] = new Node(-1,-1);
            }

        Node prev = getPrevNode(storage[primIndex],key);
        if(prev.next == null){

            prev.next = new Node(key,value);

        }else{

            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        
        int primIndex = getPrimaryHash(key);
        if(storage[primIndex] == null){
            return -1;
            }

        Node prev = getPrevNode(storage[primIndex],key);
        if(prev.next == null){

            return -1;

        }else{

            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int primIndex = getPrimaryHash(key);
        if(storage[primIndex] == null){
            return;
            }

        Node prev = getPrevNode(storage[primIndex],key);
        if(prev.next == null){

            return;

        }else{

            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
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

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
        
    }
    
    public void push(int x) {
        inSt.push(x);
        
    }
    
    public int pop() {
        if(empty()) return -1;

    if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
        
    }
    
    public int peek() {
                if(empty()) return -1;

        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
        
        
    }
    
    public boolean empty() {

        return inSt.isEmpty() && outSt.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */