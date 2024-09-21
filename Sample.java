// Time Complexity : Amortized time complexity O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes - a few compliation errors due to typos.


// Your code here along with comments explaining your approach
/* I have created 2 stacks (InSt and OutSt) and I push items in the InSt and pop from the OutSt. 
    Only when OutSt is empty, do I need to empty the InSt and push all elements to OutSt and then we are ready to pop/ peek from OutSt.
*/
class MyQueue {
    Stack<Integer> InSt;
    Stack<Integer> OutSt;
    public MyQueue() {
        InSt = new Stack<>();
        OutSt = new Stack<>();
    }
    
    public void push(int x) {
        InSt.push(x);
    }
    
    public int pop() {
        if(!OutSt.isEmpty())
        {
            return OutSt.pop();
        }
        else if (!InSt.isEmpty())
        {
            while(!InSt.isEmpty())
            {
                OutSt.push(InSt.pop());
            }
            return OutSt.pop();
        }
        else
        {
            return -1;
        }
    }
    
    public int peek() {
        if(!OutSt.isEmpty())
        {
            return OutSt.peek();
        }
        else if (!InSt.isEmpty())
        {
            while(!InSt.isEmpty())
            {
                OutSt.push(InSt.pop());
            }
            return OutSt.peek();
        }
        else
        {
            return -1;
        }
    }
    
    public boolean empty() {
        return OutSt.isEmpty()&& InSt.isEmpty();
    }
}
// Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// Time Complexity : Amortized time complexity O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes - a few compliation errors due to typos.


// Your code here along with comments explaining your approach

