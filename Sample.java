//Problem 3 - MyQueue
// Time Complexity : O(1) in amortized case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//To design a queue, I will use two stacks, one to push from Last and other to pop from front.
// I will keep pushing the values in input stack. For popping, I will check if output stack is empty,
// I will transfer all the values from input stack to output stack and pop the topmost value of output stack.


//Problem 4 - MyHashSet
// Time Complexity : O(1) amortized case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem faced


// Your code here along with comments explaining your approach
// My approach is keeping the input values in map of integer and boolean. Store the value as the key in hashmap,
// It will help me to retrieve key in O(1). When storing the value, I will store value and true pair in the map.