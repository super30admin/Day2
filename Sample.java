// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Problem 1:
//Time Complexity: O(1) Space Complexity:O(n)
/*I implemented this problem using two stacks so that to make it FIFO once I push it in one stack I will pop and push it in other stack
so that I pop it in proper queue order.*/



class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        this.st1= new Stack<>();
        this.st2=new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty())
            {
                st2.push(st1.pop());
            }
           
        }
       return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty()){
            while(!st1.isEmpty())
            {
                st2.push(st1.pop());
            }
           
        }
        return st2.peek();
    }
    
    public boolean empty() {
        if(st1.isEmpty() && st2.isEmpty())
        return true;

        else
        return false;
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







 /*Problem 2:
  * Time Complexity:O(1) and Space:O(b+n) where b is number of buckets and n is additional nodes in the linked list
   We use a primary stack of b elements and then find a primary hash through primary hash we form a linked list of nodes and perform operations
   on it depending on if its null or not. We make a seperate function to find previous node so that we can easily implement the other functions
   and handle addition or deletion of nodes.
  */


  class MyHashMap {
    class Node{
    Node next;
    int key;
    int value;
    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }}
    Node[] storage;
    int buckets;
    public MyHashMap() {
     this.buckets=10000;
     this.storage=new Node[buckets];
    }
    
    public void put(int key, int value) {
        int primaryind=getPrimaryHash(key);
        if(storage[primaryind]==null)
        {
            storage[primaryind]=new Node(-1,-1);
        }
        Node prev=getPrev(storage[primaryind],key);
        if(prev.next==null){
            Node curr=new Node(key,value);
            prev.next=curr;
            curr.next=null;
        }
        else{
            prev.next.value=value;
        }
    }
    private int getPrimaryHash(int key)
    {
        return key % buckets;
    }
    public int get(int key) {
       int primaryind=getPrimaryHash(key);
        if(storage[primaryind]==null)
        {
            storage[primaryind]=new Node(-1,-1);
        }
        Node prev=getPrev(storage[primaryind],key);
        if(prev.next==null){
            return -1;
        }
        else
        return prev.next.value;
    }

    private Node getPrev(Node head,int key)
    {
        Node prev=null;
        Node curr=head;

        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void remove(int key) {
        int primaryind=getPrimaryHash(key);
        if(storage[primaryind]==null)
        {
            storage[primaryind]=new Node(-1,-1);
        }
        Node prev=getPrev( storage[primaryind],key);
        if(prev.next==null){
            return;
        }
        else{
          Node curr=prev.next.next;
          prev.next=null;
          prev.next=curr;
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