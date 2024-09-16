// Time complexity: Push O(1), Pop O(n), Peek O(1), IsEmpty O(1)
//Amortized Time complexity for Pop O(1)
//Space Complexity O(n)
 public class MyQueue
    {

        private Stack first, second;
        /** Initialize your data structure here. */
        public MyQueue()
        {
            first = new Stack();
            second = new Stack();
        }

        /** Push element x to the back of queue. */
        public void Push(int x)
        {
            first.Push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int Pop()
        {
           Peek();
           return Convert.ToInt32(second.Pop());
        }

        /** Get the front element. */
        public int Peek()
        {
            if (second.Count == 0)
            {
                while (!(first.Count == 0))
                {
                    second.Push(first.Pop());
                }
            }
           return Convert.ToInt32(second.Peek());
        }

        /** Returns whether the queue is empty. */
        public bool Empty()
        {
            return (first.Count == 0 && second.Count == 0);
        }
    }

 // Your MyQueue object will be instantiated and called as such:
 // MyQueue obj = new MyQueue();
 // obj.Push(x);
 // int param_2 = obj.Pop();
 //int param_3 = obj.Peek();
 //  bool param_4 = obj.Empty();
 