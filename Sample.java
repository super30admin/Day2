// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Queue using 2 stacks
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    public void push(int x) {
        this.in.push(x);
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
    public Boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

//hash map
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node [] arr;
    public MyHashMap() {
        this.arr = new Node[10000];
    }
    private int idx(int key){
        return key%10000;
    }
    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value){
        int idx = idx(key);
        if(arr[idx] == null){
            arr[idx] = new Node(-1, -1);
        }
        Node prev = find(arr[idx], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int idx = idx(key);
        if (arr[idx] == null) return -1;
        Node prev = find(arr[idx], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int idx = idx(key);
        if(arr[idx] == null) return;
        Node prev = find(arr[idx], key);
        if(prev.next != null){
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
        }
    }

}


 