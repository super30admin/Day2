class MyHashSet {
    boolean[] array;

    /** Initialize your data structure here. */
    public MyHashSet() {
        array = new boolean[1000001];
    }
    
    public void add(int key) {
        array[key]=true;
        
    }
    
    public void remove(int key) {
        array[key]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return array[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */





Implement queue using stack

Time complexity : O(n)
  SPace complexity: O(n).


class MyQueue {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();
    

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(output.isEmpty())
        {Ss();
        }
        
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
          if(output.isEmpty())
        {Ss();}
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    public void Ss()
    {
        while(!input.isEmpty()){
            int temp = input.pop();
            output.push(temp);
        }
    }}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
