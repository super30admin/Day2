/*
    1. Time Complexity : For operations push - O(1),
                        pop, peek - O(1) amortized
    2. Space Complexity : O(n)   
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

class MyQueue {
    class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node in, out;
    public MyQueue() {
        in = null;
        out = null;
    }
    
    public void push(int x) {
        in = new Node(x, in);
    }

    public int pop() {
        peek();
        int ans = out.data;
        out = out.next;
        return ans;
    }

    public int peek() {
        if (out == null) {
            while (in !=null) {
                out = new Node(in.data, out);
                in = in.next;
            }
        }
        return out.data;
    }
    
    public boolean empty() {
        return in == null && out == null;
    }
    public static void main(String[] args) {
        MyQueue queue =  new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.peek());
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