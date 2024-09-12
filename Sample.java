// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// Time Complexity :O(N) FOR PEEK , PUSH
// Space Complexity :
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :

import java.util.Stack;

class MyQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()==true) {
            if (stack1.isEmpty()==false) {
                System.out.println("here inside 18");
                while (stack1.isEmpty()==false ) {
                    stack2.push(stack1.peek());
                    stack1.pop();
                }
                System.out.println("popped element = " + stack2.peek());
                return stack2.pop();
            } else {
                System.out.println("No elements in queue");
                return -1;
            }
        } else {
            System.out.println("element = " + stack2.peek());
            return stack2.pop();
        }

    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            } else {
                System.out.println("no elements in queue");
                return -1;
            }
        }
    }

    public boolean empty() {
        System.out.println("inside empty "+ !(stack1.isEmpty() || stack2.isEmpty()));
        return (stack1.isEmpty() && stack2.isEmpty());
    }
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        System.out.println("peek element "+obj.peek());

        System.out.println(" is empty "+  obj.empty());
    }

}



//hashset
//time Complexity : O(1)
//executed in leetcode : yes

class MyHashSet {
    private  boolean hashstore[][];
    public MyHashSet() {
        hashstore=new boolean[1000][1001];


    }

    public int getHash1(int key)
    {
        return key%1000;
    }

    public int getHash2(int key){
        return key/1000;
    }

    public void add(int key) {
        hashstore[this.getHash1(key)][this.getHash2(key)] =true;
    }

    public void remove(int key) {
        hashstore[this.getHash1(key)][this.getHash2(key)]=false;
    }

    public boolean contains(int key) {

        return        hashstore[this.getHash1(key)][this.getHash2(key)];
    }

    public static void main(String[] args) {
        MyHashSet obj= new MyHashSet();
        System.out.println("checking before  " + obj.contains(1));
        obj.add(1);
        System.out.println("checking before  " + obj.contains(1));

    }
}