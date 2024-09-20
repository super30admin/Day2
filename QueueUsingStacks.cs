// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

using System;
using System.Collections.Generic;

public class MyQueue
{
    private Stack<int> inSt;
    private Stack<int> outSt;

    public MyQueue()
    {
        inSt = new Stack<int>();
        outSt = new Stack<int>();
    }

    public void Push(int x)
    {
        inSt.Push(x);
    }

    public int Pop()
    {
        if (outSt.Count == 0)
        {
            while (inSt.Count > 0)
            {
                outSt.Push(inSt.Pop());
            }
        }
        return outSt.Pop();
    }

    public int Peek()
    {
        if (outSt.Count == 0)
        {
            while (inSt.Count > 0)
            {
                outSt.Push(inSt.Pop());
            }
        }
        return outSt.Peek();
    }

    public bool Empty()
    {
        return inSt.Count == 0 && outSt.Count == 0;
    }
}

// Main program to run the test case
public class Program
{
    public static void Main(string[] args)
    {
        // Example input as per the problem:
        // ["MyQueue", "push", "push", "peek", "pop", "empty"]
        // [[], [1], [2], [], [], []]

        MyQueue obj = new MyQueue();
        Console.WriteLine("null");  // Corresponds to the instantiation of the MyQueue object

        obj.Push(1);
        Console.WriteLine("null");  // Corresponds to the first push operation

        obj.Push(2);
        Console.WriteLine("null");  // Corresponds to the second push operation

        int param_3 = obj.Peek();
        Console.WriteLine(param_3);  // Expected output: 1 (peek operation)

        int param_2 = obj.Pop();
        Console.WriteLine(param_2);  // Expected output: 1 (pop operation)

        bool param_4 = obj.Empty();
        Console.WriteLine(param_4);  // Expected output: False (empty operation)
    }
}
