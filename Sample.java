// Time Complexity : O(1) for push,empty , O(N) for pop,peek
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {
    //Intuition is to have two stacks in and out and maintain in for only push
    //out will be filled with popped values from in whenever peek and pop operations
    //are performed once the out is empty
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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

// Time Complexity : O(N) for put, get and remove
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {
    Node[] storage;
    int bucket;

    private class Node{
        int key,value;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.value=val;
        }
    }

    private int getBucket(int key){
        return Integer.hashCode(key) % this.bucket;
    }

    public MyHashMap() {
        this.bucket=1000;
        this.storage=new Node[this.bucket];
    }

    private Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr=prev.next;
        while(curr!=null && curr.key != key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]==null){
            storage[bucketValue]=new Node(-1,-1);
        }
        Node prev=find(storage[bucketValue],key);

        //add a new node if not found
        if(prev.next == null){
            Node newNode=new Node(key,value);
            prev.next=newNode;
        }
        //update the existing node if not found
        else{
            prev.next.value=value;
        }
    }

    public int get(int key) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]==null){
            return -1;
        }
        Node prev=find(storage[bucketValue],key);
        if(prev.next!=null){
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]!=null){
            Node prev=find(storage[bucketValue],key);
            if(prev.next!=null){
                prev.next=prev.next.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */