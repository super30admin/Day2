# Design-2

## Explain your approach in **three sentences only** at top of your code
## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
# First declare two empty stacks, for push operation we insert data into first stack
# For pop / peek operation we transfer the elements from the first stack to the second stack
# This results in elements to be in reverse order and we always get the first element that was pushed into the first stack

## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# Initialize a private class that contains key, value and next address. The size of the array is 10000 which means we can have 100 collisions
# For the put / get operation we will find the index from the hash function update / return the value if it matches the key else we keep on updating the current address to the next address.
# To remove we will update the current node with the next of next node so that the connection is broken and the key is removed. 



