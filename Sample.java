// Time Complexity : push: O(1), pop: Amortised O(1), peek: O(1) 
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
class MyQueue {
    
    Stack<Integer> s1; //Stack 1
    Stack<Integer> s2; //Stack 2

    /** Initialize your data structure here. */
    public MyQueue() {
        s1=new Stack<>(); //Initialise the Stack 1
        s2=new Stack<>(); //Initialise the Stack 2
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x); // Push the data always into stack 1
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek(); //Shifting the elements from stack 1 to stack 2, so the last element comes to the top 
        return s2.pop(); //Pop the data always from the stack 2
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){ //checks if stack 2 is empty, so that the first element pushed always stays on the top 
        while(!s1.isEmpty()) // pushes all the elements from stack 1 to stack 2
        {
            s2.push(s1.pop()); 
        }
    }
        return s2.peek(); //returns the first pushed element
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) // if both the stacks are empty 
            return true; // return true
        else
            return false; // else return false 
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

 // Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class MyHashMap {
    
    //Defining a new Linked List
    class Node{
        int key,value; //key and value of the llist
        Node next; //the next pointer
        public Node(int key,int value) // constructor 
        { 
            this.key=key;
            this.value=value;
        }
    }
    
    Node[] nodes; // array of Node
    
    private int hash(int key)
    {
        return Integer.hashCode(key) % nodes.length; //Calculating the hash value using inside hashCode and dividing it by 10000
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes= new Node[10000]; //primary node of 10000 values 
    }
    
    private Node find(Node head,int key)
    {
        //to find the previous node
        Node prev=null; //intially the prev node is null 
        Node curr= head; // current node is set to the node's previous we want to find
        
        // trying to find the previous node
        // iterating over 100 elements
        while(curr!=null && curr.key!=key) // doing this until the current becomes null and the current's key matches the key to be found
        {
            prev=curr; //setting the prev to curr
            curr=curr.next; // setting the curr node to the next node
        }
        return prev; //return prev; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index= hash(key); // first find the hash function of the key we want to add
        if(nodes[index]==null) // if the nodes is null at that index
        {
            nodes[index]= new Node(-1,-1); // we add a dummy node
        }
        Node prev= find(nodes[index],key); //find the previous node
        if(prev.next==null) // if prev's next node is null
        {
            prev.next= new Node(key,value); // create a new node
        }
        else{
            prev.next.value= value; //else update the value
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index= hash(key); //get the index
        if(nodes[index]==null) return -1; // if the nodes array is null there return -1
        Node prev= find(nodes[index],key); // find prev node
        if(prev.next==null) return -1; // if prev's next node is null, return -1
        return prev.next.value;  // else return the prev's node next node value
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index= hash(key); // get the index
        if(nodes[index]==null) return; // if the nodes array is empty, return
        Node prev= find(nodes[index],key); // get the previous node
        if(prev.next==null) return; // if prev's next node is null return 
        prev.next= prev.next.next; // else remove the node by setting the prev's next to next.next
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
