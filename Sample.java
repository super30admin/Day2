// Time Complexity : TC of push will be O(n), for pop, peek and empty methods it will be O(1)
// Space Complexity : SC: O(n) auxiallary space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        if (st1.isEmpty())
            return true;

        return false;
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
 
 
 
 // Time Complexity : O(1) for all operations
// Space Complexity : 1000001 * O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashMap {

    int[]  arr;
    public MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 
 
 More Optimized:
 
 
  // Time Complexity : O(1) for all operations
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : little bit but later able to resolve it
 
 class MyHashMap {

    private int[][]  arr;
    private int buckets;
    private int bucketItems;
    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new int[buckets][];
    }

    private int bucket(int key){
        return key%buckets;
    }
    
    private int bucketItem(int key){
        return key/bucketItems;
    }

    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (arr[bucket] == null){
            if (bucket == 0){
                arr[bucket] = new int[bucketItems + 1];
                Arrays.fill(arr[bucket], -1);
            } else {
                arr[bucket] = new int[bucketItems];
                Arrays.fill(arr[bucket], -1);
            }
        }

        arr[bucket][bucketItem] = value;
    } 
    
    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if (arr[bucket] == null){
            return -1;
        }
        return arr[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (arr[bucket] == null)
            return;

        arr[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */