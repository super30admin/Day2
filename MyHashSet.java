/**

Problem: Design a hash set without using built-on data structures 
https://leetcode.com/problems/design-hashset/

Solution:

Design a hash set using integer array and a double-hashing function.
The first hash function results in an index within the array. The second hashing function results in a bit position. Since each element in the array is an int and can be represented using 32 bits,
we will use each bit of an integer in a particular index of the array.
Therefore, 0 - 31 can be represented in array[0], 32 - 63 in array[1] etc.

Leetcode assumes that 0 <= key <= 10^6.
Therefore, array size = 10^6 / 32 + 1 = 31251

- Time Complexity : Time complexity is O(1) for add, remove, and contains
- Space Complexity : Space complexity is O(n / 32 + 1) ~ O(n)
- Did this code successfully run on Leetcode : Yes
- Any problem you faced while coding this : My initial check in the contains function was wrong. I was checking to see if (array[arrayIndex] & (1 << bitPosition)) > 0 when it should have been != 0.
       If a number if large enough that the first bit from the left of the 32 bits is set to 1, the compiler treats it like a negative number. So > 0 check fails when it shouldn't. It took me a while to figure this out.
*/

class MyHashSet {

    int array[];
    
    public MyHashSet() {
        array = new int[31251];
    }
    
    public void add(int key) {
        int arrayIndex = getArrayIndex(key);
        int bitPosition = getBitPosition(key);
        // Set the bit
        array[arrayIndex] = (array[arrayIndex] | (1 << bitPosition));
    }
    
    public void remove(int key) {
        int arrayIndex = getArrayIndex(key);
        int bitPosition = getBitPosition(key);
        // Unset the bit
        array[arrayIndex] = array[arrayIndex] & (~(1 << bitPosition));
    }
    
    public boolean contains(int key) {
        int arrayIndex = getArrayIndex(key);
        int bitPosition = getBitPosition(key);
        // Check if bit is set to 1
        return ((array[arrayIndex] & (1 << bitPosition)) != 0);
    }
    
    private int getArrayIndex(int key) {
        return key / 32;
    }
    
    private int getBitPosition(int key) {
        return (key % 32);
    }
}