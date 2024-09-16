using System;
using System.Collections.Generic;
using System.Linq;

namespace Algorithms
{
    /// Time Complexity : O(1) for push, O(n) for Popß
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Based on the discussion in class
    public class MyQueue
    {

        Stack<int> s1;
        Stack<int> s2;
        public MyQueue()
        {
            this.s1 = new Stack<int>();
            this.s2 = new Stack<int>();
        }

        public void Push(int x)
        {
            s1.Push(x);
        }

        public int Pop()
        {
            if (s2.Count == 0)
            {
                while (s1.Count != 0)
                {
                    s2.Push(s1.Pop());
                }
            }
            return s2.Pop();
        }

        public int Peek()
        {
            if (s2.Count != 0)
            {
                return s2.Peek();
            }
            else
            {
                while (s1.Count != 0)
                {
                    s2.Push(s1.Pop());
                }
            }
            return s2.Peek();
        }

        public bool Empty()
        {
            return s1.Any() && s2.Any();
        }
    }
}

