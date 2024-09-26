// Time Complexity : push O(1), pop O(n), peek O(n), empty O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach:
1. Use 2 stacks.
2. One stack holds all pushed values.
3. While popping elements, elements from 1st stack are pushed into second stack, if second stack is empty and top 
element from the second stack is returned.

*/
import java.util.*;

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}


// Time Complexity : O(N/K) N is all elements, K is bucket array size
// Space Complexity : O(K+M) K is bucket size, M is number of unique elements added in the hashset.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach:
1. Collision avoidance with chaining with Linked List.
2. Use Bucket class to store the elements with same hash values.
3. While removing, the hash value is calculated and element is removed from the list at the hash index 
from bucket array 

*/

class MyHashSet {

    /** Initialize your data structure here. */
    private Bucket[] bucketArray;
    private int size;
    
    public MyHashSet() {
        this.size = 769;
        this.bucketArray = new Bucket[this.size];
        for(int i=0; i<this.size; i++)
            this.bucketArray[i] = new Bucket();
    }
    
    int getHash(int key) {
        return (key % this.size);
    }
    
    public void add(int key) {
        int hash = this.getHash(key);
        this.bucketArray[hash].insert(key);
    }
    
    public void remove(int key) {
        int hash = this.getHash(key);
        this.bucketArray[hash].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = this.getHash(key);
        return this.bucketArray[hash].exists(key);
    }
}

class Bucket {
    private LinkedList<Integer> containers;
    
    public Bucket() {
        containers = new LinkedList<Integer>();
    }
    
    public void insert(Integer key) {
        int index = this.containers.indexOf(key);
        if(index == -1) {
            this.containers.addFirst(key);
        }
    }
    
    public void delete(Integer key) {
        this.containers.remove(key);
    }
    
    public boolean exists(Integer key) {
        return this.containers.indexOf(key) != -1;
    }
}

