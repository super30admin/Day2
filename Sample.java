// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Time complexity is O(1) in push , empty, pop and peek is amortized O(1) as an average over multiple operations
//Code ran successfully on leetcode platform
//Space complexity : None as 2 stacks are mandatory in problem to be used. 2 stacks = 2*O(n)
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek();
        return output.pop();
    }

    //Need to do this in peek() and not in pop() as it will remove the element, to have common code usage
    public int peek() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.empty() && input.empty();
    }
}

//Time complexity is O(n) in put, get, remove, find functions/
//Code ran successfully on leetcode platform
//Space complexity : Array of 10000 objects O(N) and dummy object, prev, curr would cost constant time.

class MyHashMap {

    class Node {
        int key,value;
        Node next;
        Node(int key,int value) {
            this.key = key;
            this.value= value;
        }
    }
    Node[] storage;
    Node dummy=null, prev=null, curr=null;

    int getBucket(int key) {
        return key%10000;
    }

    public MyHashMap() {
        storage = new Node[10000];
    }

    public void find(int key, int index) {
        dummy=storage[index];
        prev=dummy;
        curr = dummy.next;
        while(curr != null && curr.key != key) {
            prev=curr;
            curr=curr.next;
        }
    }
    
    public void put(int key, int value) {
        int index= getBucket(key);
        if (storage[index] == null) {
            dummy= new Node(-1,-1);
            dummy.next = new Node(key,value);
            storage[index] = dummy;
        } else {
            //traverse the list to check if key exists or not.
            find(key,index);
            if(prev.next == null) {
                prev.next = new Node(key, value);
            } else {
                prev.next.value=value;
            }
        }

    }

    
    public int get(int key) {
        int index = getBucket(key) ;
        if (storage[index] == null) {
            return -1;
        } else {
            find(key, index);
            if(prev.next == null) {
                return -1;
            } 
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(storage[index] == null) {
            return;
        } else {
            find(key,index);
            if(prev.next != null) {
                prev.next = prev.next.next;
            }
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
