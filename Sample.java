// Time Complexity myQueue :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : just wanted a hint for logic(but thought myself)


// Time Complexity my hashset:O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : This is the same technique used which Raj sir told in the class


// Your code here along with comments explaining your approach

//
//class MyQueue {
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//    public MyQueue() {
//
//    }
//
//    public void push(int x) {
//        if(stack1.isEmpty() == true){
//            stack1.push(x);
//
//        }else if(stack1.isEmpty() == false){
//
//            while(!stack1.isEmpty()){
//                stack2.push(stack1.pop());
//            }
//            stack1.push(x);
//            while(!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//
//        }
//    }
//
//    public int pop() {
//
//        return stack1.pop();
//
//    }
//
//    public int peek() {
//
//        return stack1.peek();
//
//    }
//
//
//
//    public boolean empty() {
//
//        return stack1.isEmpty();
//    }
//}
//
///**
// * Your MyQueue object will be instantiated and called as such:
// * MyQueue obj = new MyQueue();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.peek();
// * boolean param_4 = obj.empty();
// */


//
//class MyHashSet {
//
//    boolean [][] storage;
//    int buckets;
//    int bucketitems;
//
//    public MyHashSet() {
//        buckets = 1000;
//        bucketitems = 1000;
//        storage = new boolean[buckets][];
//
//    }
//    private int getBucket(int key){
//        return key%buckets;
//    }
//
//    private int getbucketitemindex(int key){
//        return key/bucketitems;
//    }
//
//
//    public void add(int key) {
//        int bucket = getBucket(key);
//        int bucketitem = getbucketitemindex(key);
//        if(storage[bucket]==null){
//            if(bucket ==0){
//                storage[bucket] = new boolean[bucketitems+1];
//            }else
//                storage[bucket] = new boolean[bucketitems];
//        }
//        storage[bucket][bucketitem] = true;
//
//    }
//
//    public void remove(int key) {
//        int bucket = getBucket(key);
//        int bucketitem = getbucketitemindex(key);
//        if(storage[bucket]==null){
//            return;
//        }
//        storage[bucket][bucketitem] = false;
//    }
//
//    public boolean contains(int key) {
//        int bucket = getBucket(key);
//        int bucketitem = getbucketitemindex(key);
//        if(storage[bucket]==null){
//            return false;
//        }
//        return storage[bucket][bucketitem];
//    }
//
//}
//
///**
// * Your MyHashSet object will be instantiated and called as such:
// * MyHashSet obj = new MyHashSet();
// * obj.add(key);
// * obj.remove(key);
// * boolean param_3 = obj.contains(key);
// */
