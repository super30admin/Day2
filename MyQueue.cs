using System.Collections.Generic;

namespace CustomDataStructures
{
    public class MyQueue
    {
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        private Stack<int> firstStack;
        private Stack<int> secondStack;

        /** Initialize your data structure here. */
        public MyQueue()
        {
            firstStack = new Stack<int>();
            secondStack = new Stack<int>();

        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        /** Push element x to the back of queue. */
        public void Push(int x)
        {
            firstStack.Push(x);
        }

        //Time Complexity - O(n) - As part of peek, we are shifting elements from first stack to second stack
        //Space Complexity - O(2n) which boils down to O(n) - As we are utilizing two stacks as part of peek
        /** Removes the element from in front of queue and returns that element. */
        public int Pop()
        {
            Peek(); // This allows the flipping of order to FIFO when we move elements from first stack to second stack
            return secondStack.Pop();
        }

        //Time Complexity - O(n) - As part of peek, we are shifting elements from first stack to second stack
        //Space Complexity - O(2n) which boils down to O(n) - As we are utilizing two stacks as part of peek
        /** Get the front element. */
        public int Peek()
        {
            // Transfer elements of first stack to second stack to flip the order
            if (secondStack.Count == 0)
            {
                while (firstStack.Count != 0)
                {
                    secondStack.Push(firstStack.Pop());
                }
            }

            return secondStack.Peek();
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        /** Returns whether the queue is empty. */
        public bool Empty()
        {
            return firstStack.Count == 0 && secondStack.Count == 0;
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.Push(x);
     * int param_2 = obj.Pop();
     * int param_3 = obj.Peek();
     * bool param_4 = obj.Empty();
     */
}
