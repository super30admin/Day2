//Problem 1
// Time Complexity : O(1) for push ,pop , worst case for peek O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class MyQueue {
// creating two Stack in and out
Stack<Integer> in;
Stack<Integer> out;
    public MyQueue() {
    in=new Stack<>();
    out= new Stack<>();

    }
    
    public void push(int x) {
       in.push(x); 
    }
    
    public int pop() {
      peek();
      return out.pop();  
    }
    
    public int peek() {
       if(out.isEmpty())// checking if the out is empty
       {
        while(!in.isEmpty())// pushing the in stack value in out stack
        {
            out.push(in.pop());
        }
       } 
       return out.peek();// peack element will be out top
    }
    
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty(); // when the both stack is empty
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

// Your code here along with comments explaining your approach



//Problem 2
// Time Complexity : O(n) for push ,pop , worst case for peek O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class MyHashMap {
    // creating node to store key, value and the next node
class Node{
    int key,value;
    Node next;
    public Node(int key, int value)
    {
        this.key=key;
        this.value=value;
        this.next=null;
    }
}
// creating buckets to store the valu
int buckets;
Node[] storage;
private Node find(Node dummy, int key)
{ 
    Node prev=dummy;
    Node curr=dummy.next;
    while(curr!=null&&curr.key!=key)
    {
        prev=curr;
        curr=curr.next;
    }
    return prev;
}
    public MyHashMap() {
        // setting the size of the bucket and storage
        buckets=1000;
        storage=new Node[buckets];
    }// hash function 
    public int getBucket(int key)
    {
        return key%buckets;
    }
    
    public void put(int key, int value) {
        int bucket=getBucket(key);
        if(storage[bucket]==null)
        { // creating the dummy node for store the head pointer
            storage[bucket]=new Node(-1,-1);
        }
        Node prev=find(storage[bucket],key);
        if(prev.next!=null)
        {
            prev.next.value=value;// setting the value for the existing key
        }
        else{
            prev.next=new Node(key,value); // if no key is present , creating new key
        }
    }
    
    public int get(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null)
        {
            return -1; // when the bucket is empty
        }
        Node prev=find(storage[bucket],key);
        if(prev.next!=null)
        {
           return prev.next.value;// returning the curr node value
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null) return;
        Node prev=find(storage[bucket],key);
        if(prev.next!=null)
        {
            prev.next=prev.next.next;// when bucket is not empty removing the node
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