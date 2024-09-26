// Time Complexity : Array operations, no iterations so O(1)
// Space Complexity : Two stacks so twice O(N) ~ O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, some constraints doubts like, what default values to be set for peek and pop if they are empty. 
class MyQueue {

    int size = 100;// since at most 100 calls constraint
    int arr1[] = new int[100];
    int arr2[] = new int[100];
    int top1 = -1;
    int top2 = -1;
    public MyQueue() {
        top1 = -1;
        top2 = -1;
    }

    public void push(int x) {
        // check if stack is full
        if(top1 != arr1.length-1){
            top1++;
            arr1[top1] = x;
            // Copying the same to stack2
            arr2[top1] = x;
        }
    }

    public int pop() {
        // Check if the first stack is not empty and the second top not pointing at the first.
        // If both pointing at same then queue is empty
        if(!empty()){
            top2++;
            return arr2[top2];
        }
        return -1; // default error
    }

    public int peek() {
        // Check if the first stack is not empty and the second top not pointing at the first.
        // If both pointing at same then queue is empty
        if(!empty()){
            int temp = top2+1;
            return arr2[temp];
        }
        return -1; // default error
    }

    // Checking if the first stack pointer is -1 and second pointer doesnt point the first pointer
    // Similar to front == rear case.
    public boolean empty() {
        if(top1 == -1 || top1==top2){
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