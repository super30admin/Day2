// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach

/**
 * When I submitted the on leet it gave me a scenario that isempty gave a wrong output. 
 */

import java.util.Stack;

public class MyStackQueue {
    static Stack<Integer> stMain = new Stack<Integer>();
    static Stack<Integer> stTemp = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyStackQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stMain.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stMain.isEmpty()) {
            return swingit("pop");
        } else {
            return -1;
        }
    }

    public int swingit(String x) {
        int result;
        if (stMain.size() == 1) {
            result = stMain.pop();
        } else {
            while (!stMain.isEmpty()) {
                stTemp.push(stMain.pop());
            }
            if (x.equals("peek"))
                result = stTemp.peek();
            else
                result = stTemp.pop();
            while (!stTemp.isEmpty()) {
                stMain.push(stTemp.pop());
            }
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        return swingit("peek");
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stMain.isEmpty();
    }

    public static void main(String[] args) {
        MyStackQueue msq = new MyStackQueue();
        System.out.println(msq.empty());

        msq.push(1);
        msq.push(22);
        msq.push(36);
        msq.push(66);
        System.out.println(msq.pop());
        msq.push(73);
        System.out.println(msq.pop());
        msq.push(45);
        msq.push(55);
        System.out.println(msq.peek());
        System.out.println(msq.pop());
        System.out.println(msq.pop());
    }
}
