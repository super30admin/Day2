// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took reference after trying for an hour


// Your code here along with comments explaining your approach
class MyQueue {

       /** Initialize your data structure here. */
       Stack<Integer> stack1;
       Stack<Integer> stack2;
       
       public MyQueue() {
         stack1 = new Stack();
         stack2 = new Stack();
       }
       
       /** Push element x to the back of queue. */
       public void push(int x) {
               stack1.push(x);
       }
       
       /** Removes the element from in front of queue and returns that element. */
       public int pop() {
          if(stack2.isEmpty()) {
              while(!stack1.isEmpty()) {
                  stack2.push(stack1.pop());
              }
             
          }
            return stack2.pop();
       }
       
       /** Get the front element. */
       public int peek() {
          if(stack2.isEmpty()) {
             while(!stack1.isEmpty()){
                 stack2.push(stack1.pop());
             }
              return stack2.peek();
          } else {
              return stack2.peek();
          }
       }
       
       /** Returns whether the queue is empty. */
       public boolean empty() {
          if(stack1.isEmpty() && stack2.isEmpty()){
              return true;
          } else {
              return false;
          }
       }
   }

   /**Approach 2
    * Using ArrayList 
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes
   */
    //     /** Initialize your data structure here. */
    //     List<Integer> list;
    //     int pointer = 0;
    //     public MyQueue() {
    //         list = new ArrayList();;
            
    //     }
        
    //     /** Push element x to the back of queue. */
    //     public void push(int x) {
    //         list.add(x);
    //     }
        
    //     /** Removes the element from in front of queue and returns that element. */
    //     public int pop() {
    //         int index = 0;
    //         int x = list.get(index);
    //         list.remove(index);
    //         return x;
    //     }
        
    //     /** Get the front element. */
    //     public int peek() {
    //         int index = 0;
    //         int x = list.get(index);
    //         list.remove(0);
    //         list.add(0, x);
    //         return x;
            
    //     }
        
    //     /** Returns whether the queue is empty. */
    //     public boolean empty() {
    //         int index = 0;
    //         boolean exists = index == list.size();
    //         return exists;
    //     }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */




     // Problem 2: 
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


     class MyHashSet {

        /** Initialize your data structure here. */
        int[] array;
        public MyHashSet() {
            array = new int[1000001];
        }
        
        public void add(int key) {
            array[key] = 1;
        }
        
        public void remove(int key) {
            array[key] = 0;
        }
        
        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            if(array[key] == 1){
                return true;
            } else {
                return false;
            }
        }

    // Time Complexity : O(1)
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : NO
    // Any problem you faced while coding this : Getting an error while adding in the list, it would be great if you can explain the problem

    //     List<Integer> list;
    //     public MyHashSet() {
    //         list = new ArrayList();
    //     }
        
    //     public void add(int key) {
    //         list.add(key , 1);
    //     }
        
    //     public void remove(int key) {
    //         list.add(key, null);
    //     }
        
    //     /** Returns true if this set contains the specified element */
    //     public boolean contains(int key) {
    //         if(list.get(key) == null){
    //             return false;
    //         } else {
    //             return true;
    //         }
    //     }
     }
    
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */