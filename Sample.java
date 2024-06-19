// 1. Implementing Stacks Using Queue
// Time Complexity : O(1) (Amortized) O(n) Worst case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// Initialized two empty Stacks S1 and S2.
// Using Stack S1 for push function always.
// Using Stack S2 for pop and peek.
// Check if Stack S2 is empty then transfer all the elemnts from Stack S1 to Stack S2
// so in that way the bottom elements in Stack S1 becomes the top elememts in Stack S2.

// 1. Design HashMap
// Time Complexity : O(n) worstcase due to Arrays.fill(hashMap,-1);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Any better way to modify Arrays.fill() code to get time complexity O(1)

// Your code here along with comments explaining your approach:
// Initializing int[][] array. one primary and one secondary array.
// Since the key constraints is 10^6 taking %1000 for primaryArray and /1000 in secondary array.
// While performing put method check if secondary Array is initialized already, if not initiialize new one
// For the edge case value 1000000 we will be needing an extra space for storing its value in arrray[0]
// else we can initialize the secondary array with the size 1000.
// Get and Remove method is simply finding the proper indexing of a key and checking if the value exist then return accordingly