//Implement Hashset

// I faced a problem of IndexOutOfBoundException. In the Bucket class, if I give delete method's input parameters as int.
// If I give Integer as a type of parameter, code is running well. Not Sure why it is?

//Code is running fine.
// Time Complexity for add - o(1), delete - o(n) because searching of element in the linkedlist is needed foe deletion
// space complexity o(n) because we are allocating array or list of 769.
class Bucket{
    private LinkedList<Integer> container;
    
    public Bucket(){
        container = new LinkedList<>();
    }
    
    public void insert(int key){
        int idx = container.indexOf(key);
        if(idx == -1)
            container.addFirst(key);
    }
    
    public void delete(Integer key){
        container.remove(key);
    }
    
    public boolean exists(int key){
        return container.indexOf(key) == -1 ? false : true;
    }
}
class MyHashSet {
    private int key_space;
    private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        key_space = 769;
        hash_table = new ArrayList<>();
        for(int i=0;i<key_space;++i)
        {
             hash_table.add(new Bucket());
        }
    }
    
    public void add(int key) {
        int hash_key = key % key_space;
        hash_table.get(hash_key).insert(key);
    }
    
    public void remove(int key) {
        int hash_key = key % key_space;
        hash_table.get(hash_key).delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash_key = key % key_space;
        return hash_table.get(hash_key).exists(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//Implement Queue using stacks

//Time Complexity: Push - o(1), Pop - o(1), worstcase -o(n), Peek - o(1)
//Space complexiety o(n)

// Yes the code run successfully. I didn't faced any problem while solving.
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.front = -1;
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //if stack1 is empty, initialize the front with the given element.
        if(s1.isEmpty())
        {
            front = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //if the stack 2 is empty then the stack1 elements are needed to stored in the stack2
        if(s2.isEmpty())
        {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        //condition to checkl if the stack 2 is empty or not
        if(!s2.isEmpty())
            return s2.peek();
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //if the both stacks are empty then the queue is empty
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
        
    }
}
