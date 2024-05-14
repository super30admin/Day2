/**
 *
 * // Time Complexity : O(1)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
public class QueueUsingStacks {
    Stack<Integer> in;
    Stack<Integer> out;
    int oldest;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        in = new Stack<>();
        out = new Stack<>();
        oldest = 0;
    }


    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 *
 * // Time Complexity : O(1)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */

public class DesignHashSet {
    int bucket;
    int bucketItem;
    boolean storage[][];
    /** Initialize your data structure here. */
    public DesignHashSet() {
        bucket = 1001; // because the range is 0 to million
        bucketItem=1000;
        storage = new boolean[bucket][];
    }

    /**
     * Hash formula to get the index of the bucket to insert a value (inside a nested array)
     * @param key the key
     * @return the bucket index
     */
    private int bucketHash(int key){
        return key%bucket; // eg: 4%1001
    }

    /**
     * Hash formula to get the index of the Array inside the chosen bucket to insert a value
     * @param key the key
     * @return the nested array's index
     */
    private int bucketItemHash(int key){
        return key/bucket; //eg: 800/1000
    }


    public void add(int key) {
        // getting the indexes
        int bucketToAdd = bucketHash(key);
        int bucketItemIndex = bucketItemHash( key);


        if(storage[bucketToAdd] == null){ // that means this bucket is never used
            storage[bucketToAdd] = new boolean[bucketItem]; // so create a array inside this bucket
        }
        storage[bucketToAdd][bucketItemIndex] = true;
    }

    public void remove(int key) {
        int bucketToAdd = bucketHash(key);
        int bucketItemIndex = bucketItemHash( key);

        if(storage[bucketToAdd] != null){
            storage[bucketToAdd][bucketItemIndex] = false;
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketToAdd = bucketHash(key);
        int bucketItemIndex = bucketItemHash( key);
        if(storage[bucketToAdd] == null){
            return false;
        }
        return storage[bucketToAdd][bucketItemIndex];
    }
}
