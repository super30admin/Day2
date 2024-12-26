// Problem Name: Create Queue using Stacks
// Leetcode problem Number : 232 https://leetcode.com/problems/implement-queue-using-stacks/
// Time Complexity : It's amortized O(1)
// Space Complexity : O(2n) but I am confused 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> first;               //Declared 2 stacks first & second
    Stack<Integer> second;
    public MyQueue() {                  //Initialized them into a constructor    
        first=new Stack<>();
        second=new Stack<>();
    }
    
    public void push(int x) {              //For pushing an element we are using an inbuilt push method  
        first.push(x);
    }
    
    public int pop() {                      //For Pop we are calling a peek method which checks if second stack is empty if so then we are transferring all the elements in second stack from first till it becomes empty
        peek();                             //and then pop and return the element    
        return second.pop();
    }
    
    public int peek() {                     // peek method checks if second stack is empty if so then we are transferring all the elements in second stack from first till it becomes empty
    
        if(this.second.isEmpty()){  
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        return second.peek();                  //returns second stack peek/top element 
    }
    
    public boolean empty() {                    //This function checks if the both stacks are empty
        if(first.isEmpty() && second.isEmpty()){
            return true;
        }
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


// Problem Name: Implement Hash Map
// Leetcode problem Number : 706 https://leetcode.com/problems/design-hashmap/
// Time Complexity : O(n)
// Space Complexity : I am not sure because the array will be of fix length but the Linked List is created dynamically. Also how it will impact if we increase the size of array to 10000 from 1000
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No, As I referred to the lecturn recording and coded side by side


class MyHashMap {

    class Node{                           // created a class Node with 3 things in each node key, value, next and initialized in in a constructor
        int key,value;
        Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node[] storage;                             //Declared an array of type Node as we will be storing aaddress od dummy Node
    int buckets;
    public MyHashMap() {
        this.buckets = 10000;                   //Declared the bucket size of 10000 because on leetcode it gave better performance that 1000
        storage=new Node[this.buckets];         //assign storage a size of the buckets 
    }
    private int myHash(int key){                //this is the hash function. I also tried using Integer.hashCode(key) but it's performance was not good on leetcode so used this
        return key % this.buckets;
    }

    private Node find(Node dummy, int key){     //This is the generalised function which finds and returns the prev node so this function can be reused in get, piut and removce operations
        Node prev=dummy;                        //This functions will traverse the LinkedList at that index in storage. we are maintaining dummy in case if the node we want to remove is the first node and we can't traverse back and also for that we are maintaining a prev node pointer
        Node curr=prev.next;    
        while(curr!=null && curr.key != key){   //This loop will run till current node is not null aand current's key is not equal to the key as we are returning previous node 
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {       //This function first calls the hash function checks if  that index has null if so that means there is no LinkedList present and creates a dummy node and assigns at that index
        int index=myHash(key);
        
        if(storage[index]==null){
            storage[index]=new Node(-1,-1);
        }
        Node prev = find(storage[index],key);   //Calls the find function which will return prev node and then there can be two cases 
        if(prev.next==null){                    // 1.prev is the last node if so create and add a new node                   
            prev.next=new Node(key,value);      // 2. That key already exists then update it's value to the new value
        }else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {                  //This function first calls the hash function checks if  that index has null if so that means there is no LinkedList present and if not then return a -1;

        int index=myHash(key);
        
        if(storage[index]==null){
            return -1;
        }
        else{
            Node prev = find(storage[index],key);     //Calls the find function which will return prev node and then there can be two cases
            if(prev.next!=null){                     // 1.prev is not the last node if so return the value of previous next's value
                return prev.next.value;
            }
            return -1;
        }
        
    }
    
    public void remove(int key) {             
        int index=myHash(key);               //This function first calls the hash function checks if  that index has null if so that means there is no LinkedList present and returns -1;
        if(storage[index]==null){
            return;
        }
        else{
            Node prev = find(storage[index],key);      //once we get prev if prev.next != null then we will remove and assign  prev.next =prev.next.next;
            if(prev.next==null){
                return;
            }
            else{
                prev.next =prev.next.next;
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