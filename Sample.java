//Design-2

//Implementing Queue using Stack
// Time Complexity :pop and peek function the TC at worst case will be O(N). So Total TC will be O(N) in worst case
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> st1;//I am using 2 stacks for implementing queues//
    Stack<Integer> st2;


    /** Initialize your data structure here. */
    public MyQueue() {//Intializing 2 Stacks
        st1=new Stack<>();
        st2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);//pushing data into first stack

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //during pop operation we want to remove first element as we are implementing queue
        //So if stack2 is empty we will pop all the elements from stack1 and push into stack 2
        // Now we pop element from stack 2 so the first enetered  elements are removed
        if(!st2.isEmpty()) return st2.pop();
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();

    }

    /** Get the front element. */
    public int peek() {
        //This is also same as the pop operation but we dont pop element but we retuen first entered element
        if(!st2.isEmpty()) return st2.peek();
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //If both stacks are empty return true
        if(st1.isEmpty()&&st2.isEmpty()) return true;
        return false;

    }
}

//Design Hash Set
// Time Complexity :O(K) where K is size of linked list for both adding and removing element
// Space Complexity :O(N+K) where N is the size of actual array bucket and K is size of linked list
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I have got the null pointer exception because
// of linked list and java concurrent modification error where i am looping and removing from list at same time.



// Your code here along with comments explaining your approach

class MyHashSet {

    /** Initialize your data structure here. */
    //Initializing Array of Linkedlist
    LinkedList<Integer>[] OutArr;
    public MyHashSet() {
        OutArr=new LinkedList[10000];
    }

    public void add(int key) {
        //we are calculating the bucket so we get to know where we need to add the key.
        int bucket=key%10000;
        if(OutArr[bucket]==null){//if bucket is null creating linkedlist and adding the key
            OutArr[bucket]=new LinkedList<Integer>();
            OutArr[bucket].add(key);

        }
        else{// if bucket is not null we are traversing through linked list and checking if key is already present
            for(Integer val:OutArr[bucket]){
                if(val==key) return;
            }
            // if key isn't present we are adding key to the linked list
            OutArr[bucket].add(key);
        }

    }

    public void remove(int key) {
        int bucket=key%10000;// we are claculating the bucket to remove the key
        Integer rem=null;
        if(OutArr[bucket]==null) return;//if bucket is null no key present
        for(Integer val:OutArr[bucket]){//we are traversing through linkedlist to find the key
            if(val==key) rem=val;
        }
        if(rem==null) return;//if key is not present return
        OutArr[bucket].remove(rem);//if it present remove

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket=key%10000;
        if(OutArr[bucket]==null) return false;
        else
        {
            //travesring through linked list to check if key is present or not
            for(Integer val:OutArr[bucket]){
                if(val==key) return true;

            }
            return false;
        }

    }
}
