// Time Complexity : O(1) for peek(), O(n) for empty(), Worst case O(n) and best case O(1) for push(), O(n) for pop()
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No (apart from failing test cases that were fixed later on)

class MyQueue {
    /** Initialize your data structure here. */
    int[] mainArray; //The main array
    int[] tempArray; //The array used to exapand or reduce the size of the main array
    int indexPointer; //Index of the last non-0 element on the array

    public MyQueue() {
        mainArray = new int[10];
        indexPointer = 0; 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        /* 1. If the last non-0 element is at index 9, the size limit of the main array has been reached
        Use the temp array to increase the size of the main array by 10, 
        copy all elements to the temp array and reassign the temp array to the main array
        2. Push the element at the inde pointed by 'indexPointer'
        3. And increment 'indexPointer' as new non-0 element has been added 
        */ 
        if(indexPointer==9)
        {
            tempArray = new int[mainArray.length+10];
            System.arraycopy(mainArray, 0, tempArray, 0, mainArray.length);
            mainArray = tempArray;
        }
        mainArray[indexPointer] = x;
        indexPointer++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /* 1. Copy all elements to the temp array from the main array but from index 1 as element on index 1 is to be popped 
        2. Store the element at 0 from main array in a variable and reassign the temp array to the main array
        3. And decrement 'indexPointer' as the element on index 0 has been removed 
        */ 
        tempArray = new int[mainArray.length+10];
        System.arraycopy(mainArray, 1, tempArray, 0, mainArray.length-1);
        int intToReturn = mainArray[0];
        mainArray = tempArray;
        indexPointer--;
        return intToReturn;
    }
    
    /** Get the front element. */
    public int peek() {
        return mainArray[0];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        /* The main array will at least at 10 elements with values 0. 
        While ietrating, if there's even a single non-0 value in the main array, return false as there's at least 1 element that was pushed */ 
        for(int i=0; i<=mainArray.length-1; i++)
        {
            if(mainArray[i]!=0)
                return false;
        }
        return true;
    }
}

public class Sample {
    public static void main(String[] args)
    {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();
        obj.push(5);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
    }
}