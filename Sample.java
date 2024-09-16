// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> st;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> stTmp = new Stack();
        while(!st.isEmpty())
            stTmp.push(st.pop());
        st.push(x);
        while(!stTmp.isEmpty())
            st.push(stTmp.pop());
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return st.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
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

 // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {
    List<List<Integer>> list;
    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new LinkedList<List<Integer>>();
        for(int index=0;index<10;index++)
            list.add(new LinkedList<Integer>());
    }
    
    public boolean exists(int key,int index) {
        // if(list.get(index)==null)
        //     list.set(index, new LinkedList<Integer>());
        
        List<Integer> tmpList = list.get(index);
        
        for(int tmpVal:tmpList)
            if(tmpVal==key)
                return true;
        
        return false;
    }
    
    public void add(int key) {
        // System.out.println(list);
        int index=key%10;
        if(!exists(key,index) || list.get(index).size()==0 )
            list.get(index).add(key);
    }
    
    public void remove(int key) {
         int index=key%10;
        if(exists(key,index))
            list.get(index).remove(Integer.valueOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return exists(key,key%10);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
