# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
class MyQueue {

    /** Initialize your data structure here. */
    
         Stack<Integer> pushStack = new Stack();
         Stack<Integer> popStack = new Stack();
    
    
    /** Push element x to the back of queue. */
    public void push(int x) {
       if(pushStack.isEmpty()){
            pushStack.push(x);
        }else{
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
 
            pushStack.push(x);
 
            while(!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }    
        }
    
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return pushStack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
       return pushStack.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty();
    }
}

Time Compexity : O(1)
Space Complexity: O(n)
The Time Complexity is O(1) because each time we are pushing one element and popping one element.
The Space Complexity is O(n) because we need to enqueue all the n elements into the queue.

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashSet {
    private final int Array_Size = 100;
    private List<List<Integer>> parentList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(Array_Size);
        for(int i=0;i<Array_Size;i++){
            parentList.add(null);
        }
        
    }
    
    public void add(int key) {
        int index = key % Array_Size;
        List<Integer> childList = parentList.get(index);
        if(childList==null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index,list);
        }
        else{
            if(!childList.contains(key))
                childList.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key % Array_Size;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % Array_Size;
        List<Integer> childList = parentList.get(index);
        return ((childList!=null)&&childList.contains(key));
    }
}

/**
* The Time Complexity depends on array_Size.
*/


