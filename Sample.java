//Problem-1
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* Here we are using to stacks to implement the queue. First we push the values into the stack1
and for poping we pop from one and push to another and pop from that stack so that we get queue functionality FIFO.
*/

class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    int top=0;
    public MyQueue() {
        stk1= new Stack<>();
        stk2 = new Stack<>();

    }

    public void push(int x) {
        stk1.push(x);

    }

    public int pop() {
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        int x = stk2.pop();
        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        return x;
    }

    public int peek() {
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        int x = stk2.peek();
        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        return x;

    }

    public boolean empty() {
        if(stk1.isEmpty()&&stk2.isEmpty()) return true;
        else return false;

    }
}
//Problem-2
// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/* Here we create our own hashset using the 2d array. we insert the values to it by getting the index from the hashcodes defined
We define hashcode in such a way to avoid max number of collisions.For inserting the value to the hashset ,
first we find the hashcode for it, we go to that index and check if nested array exists, if so then we calculate the second hashcode and
go to that position and insert the value over there.
If nested hashset is not present then we initialize the value over there. We go through the same for the remaining operations.
*/

class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];

    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new boolean[bucketItems+1];
            }
            else{
                storage[bucket]= new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]= true;
    }

    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;

    }

    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];

    }
}
