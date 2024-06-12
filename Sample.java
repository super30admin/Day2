// Time Complexity : O(1) for get, put, and remove
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//Collision is handled via chaining - LinkedList

/************************************ DESIGN HASHSET ****************************************/
class MyHashSet {

    /** Initialize your data structure here. */
    LinkedList<Entry>[] map;
    public static int size = 10000;
    public MyHashSet() {
        map = new LinkedList[size];
    }
    
    /* We calculate the bucket. Once we have the bucket, if it's not null, we initialise a linkedlist in that bucket
    and insert the key. If the bucket contains the key, we break as set doesn't allow us to add duplicate values.*/
    public void add(int key) {
        int bucket = key % size;
			if(map[bucket] == null) {
				map[bucket] = new LinkedList<Entry>();
				map[bucket].add(new Entry(key));
			}
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key){
						return;
					}
				}
				map[bucket].add(new Entry(key));
			}
    }
    
    /* We calculate the bucket. For every entry, we check if the key exists. If yes, we store the entry in an entry object. If the
    object is null, we simply return. If it's not null,it means the key exists. We use the remove method to remove the key*/
    public void remove(int key) {
        int bucket = key % size;
			Entry toRemove = null;
			if(map[bucket] == null) return;
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key) {
						toRemove = entry;
					}
				}
				if(toRemove == null) return;
				map[bucket].remove(toRemove);
			}
    }
    
    /** Returns true if this set contains the specified element */
    /** We check the base condition -> if the bucket is null or not. If ot's not empty, we chceck if the key exists in the entry or not.
     We return false if it doesn't exist and true if it does exist.*/
    public boolean contains(int key) {
        int bucket = key % size;
			LinkedList<Entry> entries = map[bucket];
			if(entries == null) return false;
			for(Entry entry : entries) {
				if(entry.key == key) return true;
			}
			return false;
    }
}

class Entry{
    public int key;
    public Entry(int key){
        this.key = key;
    }
}


/************************************ IMPLEMENT QUEUE USING STACK ****************************************/

// Time Complexity : O(1) for all. Pop might have a time complextiy of O(n) in the worst case
// Space Complexity : O(n) for push and pop. O(1) for peek and empty 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    private int top;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    /* We keep a track of the front element using the top variable. */
    public void push(int x) {
        if(s1.empty()){
            top = x;
        }
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    /* We transfer the elements from s1 to s2. Now the first element inserted is on the top of s2. So, we pop it.*/
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
        
    }
    
    /** Get the front element. */
    /* s2 contains the first inserted element on top. If s2 is not empty, we return the top element, else we
    have used the top variable to keep a track of the first element. We return top. */
    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
