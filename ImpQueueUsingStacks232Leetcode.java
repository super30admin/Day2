// Time Complexity :    O(1) for all operations
// Space Complexity :   O(n)
//  Yes, It's run successfully
// No I don't face any problem.



import java.util.Stack;

public class ImpQueueUsingStacks232Leetcode {

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        //myQueue.peek();
        System.out.println(myQueue.peek());// return 1
        //myQueue.pop();
        System.out.println(myQueue.pop());// return 1, queue is [2]
        //myQueue.empty();
        System.out.println(myQueue.empty());// return false
    }
}

class MyQueue {

    Stack<Integer> queue;

    public MyQueue() {
        queue = new Stack<>();
    }

    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        if(!empty()){
            return queue.remove(0);
        }
        return -1;
    }

    public int peek() {
        if(!empty()){
            return queue.get(0);
        }
        return -1;
    }

    public boolean empty() {
        if(queue.size()==0){
            return true;
        }
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
